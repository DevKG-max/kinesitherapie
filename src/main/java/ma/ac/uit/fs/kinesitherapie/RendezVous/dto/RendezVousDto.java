package ma.ac.uit.fs.kinesitherapie.RendezVous.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record RendezVousDto(String patientName,String numeroRendezVous, LocalDate dateRendezVous, LocalTime heureRendezVous,
                            String statut, String user_creation, String observation,LocalDateTime datePriseRendezVous) {
}
