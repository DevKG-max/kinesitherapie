package ma.ac.uit.fs.kinesitherapie.Patients.controllers;

import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientObjectDto;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientsDto;
import ma.ac.uit.fs.kinesitherapie.Patients.dto.PatientsListDto;
import ma.ac.uit.fs.kinesitherapie.Patients.services.PatientServiceImpl;
import ma.ac.uit.fs.kinesitherapie.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/")
    public ResponseEntity<List<PatientsListDto>> getListPatients(){
        return ResponseEntity.ok(patientService.patients());
    }
    @PostMapping("/save")
    public ResponseEntity<ResponseData> savePatient(@RequestBody PatientObjectDto objectDto){
        return  ResponseEntity.ok(patientService.createPatient(objectDto));
    }

    @PostMapping("/find")
    public ResponseEntity<List<PatientsDto>> findPatient(@RequestBody String patientName){
        return ResponseEntity.ok(patientService.patients(patientName));
    }


}
