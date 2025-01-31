package ma.ac.uit.fs.kinesitherapie.RendezVous.dao;

import ma.ac.uit.fs.kinesitherapie.RendezVous.dto.RendezVousDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

    List<RendezVous> findByDateRendezVous(LocalDateTime date);
   // List<RendezVous> findByPatient(Long idPatient);

    @Query("""
    select new ma.ac.uit.fs.kinesitherapie
                                    .RendezVous
                                        .dto
                                        .RendezVousDto( p.nom,r.numeroRendezVous,  r.dateRendezVous,
                                                              r.statut,u.displayName,r.observation, r.dateCreation
                                                       )
    from   Patients p 
    inner join RendezVous  r on (p.idPatient = r.patient.idPatient)
    inner join AuthUsers   u on (r.userCreation.idUser = u.idUser)

    where  r.uuidRendezVous = :uuidRendezVous
""")

    RendezVousDto getRendezVous(@Param("uuidRendezVous") UUID uuidRendezVous);
}
