package ma.ac.uit.fs.kinesitherapie.RendezVous.services;

import ma.ac.uit.fs.kinesitherapie.Auths.dao.AuthRepository;
import ma.ac.uit.fs.kinesitherapie.Auths.entities.AuthUsers;
import ma.ac.uit.fs.kinesitherapie.Patients.dao.PatientRepository;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.RendezVousPatientDto;
import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dao.RendezVousRepository;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dto.RendezVousDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dto.RendezVousObjectDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.entities.RendezVous;
import ma.ac.uit.fs.kinesitherapie.RendezVous.enums.Statut;
import ma.ac.uit.fs.kinesitherapie.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RendezVousServiceImpl implements RendezVousService{
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public ResponseData createRendezVous(RendezVousObjectDto data) {
        Patients  patient   = patientRepository.findPatientsByUuidPatient(data.uuidPatient());
        AuthUsers user      = authRepository.findByUuidUser(data.userCreation());
        RendezVous rendezVous = new RendezVous();
        RendezVous savedRendezVous = null;
        ResponseData responseData = null;
        String message = null;
        if (patient == null ){
            message ="Désolé, nous n'avons pas pu identifiez le patient spécifié !";
        }
        if (user == null ){
            message ="Désolé, nous n'avons pas pu identifiez l'utilisateur ayant initié l'opération !";
        }
        if (patient != null && user != null){
            rendezVous.setDateRendezVous(data.dateRendezVous());
            rendezVous.setStatut(Statut.ENCOURS);
            rendezVous.setPatient(patient);
            rendezVous.setUserCreation(user);
            rendezVous.setDateCreation(LocalDateTime.now());
            rendezVous.setUuidRendezVous(UUID.randomUUID());
            savedRendezVous = rendezVousRepository.save(rendezVous);
            message ="Rendez-vous enregistré avec succès !";
        }

        if (savedRendezVous != null){
            responseData = new ResponseData(1, message,savedRendezVous.getUuidRendezVous());
        }else {
            message = "Désolé, une erreur s'est produite lors de l'enregistrement du rendez-vous !" ;
            responseData = new ResponseData(0, message,null);

        }

        return  responseData;
    }

    @Override
    public void annulerRendezVous(RendezVous rendezVous) {

    }

    @Override
    public void confirmerRendezVous(RendezVous rendezVous) {

    }

    @Override
    public RendezVous reporterRendezVous(RendezVous rendezVous) {
        return null;
    }

    @Override
    public List<RendezVous> getRendezVousByDate(LocalDateTime date) {
        return null;
    }

    @Override
    public List<RendezVous> getRendezVousByDateBetween(LocalDateTime dateDebut, LocalDateTime dateFin) {
        return null;
    }

    @Override
    public List<RendezVous> getRendezVousByPatient(String patientName) {
        return null;
    }

    @Override
    public RendezVousDto getRendezVous(UUID uuidRendezVous) {
      return   rendezVousRepository.getRendezVous(uuidRendezVous);
    }

    @Override
    public List<RendezVousPatientDto> getRendezVousPatient(UUID uuidPatient) {
        return patientRepository.getRendezVousPatient(uuidPatient);
    }
}

