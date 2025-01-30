package ma.ac.uit.fs.kinesitherapie.Patients.dto;

import java.util.UUID;

public record PatientsDto(String patientName, String patientLastName, String Contact, UUID uuidPatient) {
}
