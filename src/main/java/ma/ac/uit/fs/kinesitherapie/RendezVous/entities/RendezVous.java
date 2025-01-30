package ma.ac.uit.fs.kinesitherapie.RendezVous.entities;

import jakarta.persistence.*;
import ma.ac.uit.fs.kinesitherapie.Auths.entities.AuthUsers;
import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRendezVous;
    private String numeroRendezVous;
    private String statut;
    private LocalDate date;
    private LocalTime heure;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patients patient;

    @ManyToOne
    @JoinColumn(name = "user_creation", nullable = false)
    private AuthUsers userCreation;

    private LocalDateTime dateCreation;
    private UUID uuidRendezVous;
    public Long getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(Long idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public AuthUsers getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(AuthUsers userCreation) {
        this.userCreation = userCreation;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}
