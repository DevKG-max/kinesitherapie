package ma.ac.uit.fs.kinesitherapie.Patients.dto;

import ma.ac.uit.fs.kinesitherapie.RendezVous.enums.Statut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record RendezVousPatientsDto(String patientName, String patientLastName, LocalDateTime dateRendezVous, Statut statut, UUID uuidRendezVous) {
}
