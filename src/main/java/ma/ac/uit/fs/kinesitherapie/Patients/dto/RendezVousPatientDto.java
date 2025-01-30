package ma.ac.uit.fs.kinesitherapie.Patients.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record RendezVousPatientDto(String numeroRendezVous, LocalDate dateRendezVous, LocalTime heureRendezVous,
                                   String statut, UUID uuidRendezVous) {
}
