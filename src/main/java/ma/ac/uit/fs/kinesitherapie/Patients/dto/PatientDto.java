package ma.ac.uit.fs.kinesitherapie.Patients.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PatientDto(String patientName,String patientLastName,String contact, String adresse,
                         LocalDate dateNaissance,String userCreation, LocalDateTime dateCreation) {
}
