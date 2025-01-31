package ma.ac.uit.fs.kinesitherapie.RendezVous.controllers;

import ma.ac.uit.fs.kinesitherapie.Patients.dto.RendezVousPatientDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dto.RendezVousDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dto.RendezVousObjectDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.services.RendezVousServiceImpl;
import ma.ac.uit.fs.kinesitherapie.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rendez-vous")
public class RendezVousController {
    @Autowired
    private RendezVousServiceImpl rendezVousService;

    @PostMapping("/save")
    public ResponseEntity<ResponseData> saveRendezVous(@RequestBody RendezVousObjectDto objectDto){
        return ResponseEntity.ok(rendezVousService.createRendezVous(objectDto));
    }
    @PostMapping("/get")
    public ResponseEntity<RendezVousDto> getRendezVous(@RequestBody UUID uuidRendezVous){
        return ResponseEntity.ok(rendezVousService.getRendezVous(uuidRendezVous));
    }
    @PostMapping("/gets")
    public ResponseEntity<List<RendezVousPatientDto>> getRendezVousPatient(@RequestBody UUID uuidPatient){
        return ResponseEntity.ok(rendezVousService.getRendezVousPatient(uuidPatient));
    }
}
