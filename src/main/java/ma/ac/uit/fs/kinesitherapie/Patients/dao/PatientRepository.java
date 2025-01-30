package ma.ac.uit.fs.kinesitherapie.Patients.dao;

import ma.ac.uit.fs.kinesitherapie.Patients.dto.*;
import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patients, Long> {

    @Query("""
    select new ma.ac.uit.fs.kinesitherapie
                                    .Patients
                                        .dto
                                        .PatientDto( p.nom,     p.prenom,       p.telephone,
                                                     p.adresse, p.dateNaissance,u.displayName,
                                                     p.dateCreation
                                                    )
    from   Patients p 
    inner join AuthUsers  u on (p.userCreation.idUser = u.idUser)
    where  p.uuidPatient = :uuidPatient
""")
    PatientDto getPatientsByUuid(@Param("uuidPatient") UUID uuidPatient);

    @Query("""
    select new ma.ac.uit.fs.kinesitherapie
                                    .Patients
                                        .dto
                                        .PatientsDto( p.nom,     p.prenom,   p.telephone,
                                                      p.uuidPatient
                                                    )
    from   Patients p 
    inner join AuthUsers  u on (p.userCreation.idUser = u.idUser)
    where  p.nom like concat( '%', :nom, '%') or p.prenom like concat( '%', :nom, '%')
""")
    List<PatientsDto> getPatientsByNomOrPrenom(@Param("nom") String nom);

    @Query("""
    select new ma.ac.uit.fs.kinesitherapie
                                    .Patients
                                        .dto
                                        .RendezVousPatientDto( r.numeroRendezVous,  r.date,   r.heure,
                                                                r.statut, r.uuidRendezVous
                                                              )
    from   Patients p 
    inner join RendezVous  r on (p.idPatient = r.patient.idPatient)
    where  p.uuidPatient = :uuidPatient
""")
    List<RendezVousPatientDto> getRendezVousPatient(@Param("uuidPatient") UUID uuidPatient);

    @Query("""
    select new ma.ac.uit.fs.kinesitherapie
                                    .Patients
                                        .dto
                                        .RendezVousPatientsDto( p.nom,     p.prenom,  r.date,   r.heure,
                                                                r.statut, r.uuidRendezVous
                                                              )
    from   Patients p 
    inner join RendezVous  r on (p.idPatient = r.patient.idPatient)
    where   p.nom like concat( '%', :nom, '%') or p.prenom like concat( '%', :nom, '%')
""")

    List<RendezVousPatientsDto> getRendezVousPatient(@Param("nom") String nom);

    @Query("""
    select new ma.ac.uit.fs.kinesitherapie
                                    .Patients
                                        .dto
                                        .PatientsListDto( p.uuidPatient, concat( p.nom  ,  p.prenom)
                                                         )
    from   Patients p
""")
    List<PatientsListDto> getPatients();

    Patients findPatientsByUuidPatient( UUID uuidPatient);

}
