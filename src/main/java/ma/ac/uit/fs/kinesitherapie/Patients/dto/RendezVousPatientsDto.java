package ma.ac.uit.fs.kinesitherapie.Patients.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record RendezVousPatientsDto(String patientName, String patientLastName, LocalDate dateRendezVous,
                                    LocalTime heureRendezVous, String statut, UUID uuidRendezVous) {
}
