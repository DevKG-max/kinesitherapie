package ma.ac.uit.fs.kinesitherapie.RendezVous.dto;

import ma.ac.uit.fs.kinesitherapie.RendezVous.enums.Statut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record RendezVousDto(String patientName, String numeroRendezVous, LocalDateTime dateRendezVous,
                            Statut statut, String user_creation, String observation, LocalDateTime datePriseRendezVous) {
}
