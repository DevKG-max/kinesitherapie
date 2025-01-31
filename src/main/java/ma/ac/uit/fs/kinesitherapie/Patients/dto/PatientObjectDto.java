package ma.ac.uit.fs.kinesitherapie.Patients.dto;

import java.time.LocalDate;
import java.util.UUID;

public record PatientObjectDto(String patientName, String patientLastName, String contact, String adresse,
                               LocalDate dateNaissance, UUID userCreation) {
}
