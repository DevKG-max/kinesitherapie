package ma.ac.uit.fs.kinesitherapie.RendezVous.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record RendezVousObjectDto(LocalDateTime dateRendezVous, UUID uuidPatient, String userCreation) {
}
