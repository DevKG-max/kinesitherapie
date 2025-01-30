package ma.ac.uit.fs.kinesitherapie.Patients.services;

import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;

import java.util.List;

public interface PatientService {

    Patients createPatient(Patients patients);
    List<Patients> patients();
    List<Patients> patients(String patientName);
    Patients updatePatient(Patients patients);


}
