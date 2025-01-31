package ma.ac.uit.fs.kinesitherapie.Patients.services;

import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientObjectDto;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientsDto;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientsListDto;
import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;
import ma.ac.uit.fs.kinesitherapie.utils.ResponseData;

import java.util.List;

public interface PatientService {

    ResponseData createPatient(PatientObjectDto patientObjectDto);
    List<PatientsListDto> patients();
    List<PatientsDto> patients(String patientName);
    Patients updatePatient(Patients patients);


}
