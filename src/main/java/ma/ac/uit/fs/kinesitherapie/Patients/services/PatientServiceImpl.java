package ma.ac.uit.fs.kinesitherapie.Patients.services;

import ma.ac.uit.fs.kinesitherapie.Auths.dao.AuthRepository;
import ma.ac.uit.fs.kinesitherapie.Auths.entities.AuthUsers;
import ma.ac.uit.fs.kinesitherapie.Patients.dao.PatientRepository;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientObjectDto;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientsDto;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientsListDto;
import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;
import ma.ac.uit.fs.kinesitherapie.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AuthRepository authRepository;
    @Override
    public ResponseData createPatient(PatientObjectDto data) {
        AuthUsers user = authRepository.findByUuidUser(data.userCreation().toString());
        Patients patients = new Patients();
        Patients savedPatient = null;
        ResponseData responseData = null;
        String message = null;
        if (user == null)
            message ="Désolé, nous n'avons pas pu identifiez l'utilisateur ayant initié l'opération !";
        if (user != null) {
            patients.setAdresse(data.adresse());
            patients.setNom(data.patientName());
            patients.setPrenom(data.patientLastName());
            patients.setTelephone(data.contact());
            patients.setUserCreation(user);
            patients.setDateNaissance(data.dateNaissance());
            patients.setDateCreation(LocalDateTime.now());
            savedPatient = patientRepository.save(patients);
            message ="Patient enregistré avec succès !";
        }
        if (savedPatient != null){
            responseData = new ResponseData(1, message,savedPatient.getUuidPatient());
        }else {
            message = "Désolé, une erreur s'est produite lors de l'enregistrement du patient !" ;
            responseData = new ResponseData(0, message,null);

        }

        return  responseData;

    }

    @Override
    public List<PatientsListDto> patients() {
        return patientRepository.getPatients();
    }

    @Override
    public List<PatientsDto> patients(String patientName) {
        return patientRepository.getPatientsByNomOrPrenom(patientName);
    }

    @Override
    public Patients updatePatient(Patients patients) {
        return null;
    }
}
