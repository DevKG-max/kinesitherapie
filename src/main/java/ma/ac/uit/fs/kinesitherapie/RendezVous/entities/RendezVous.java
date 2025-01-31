package ma.ac.uit.fs.kinesitherapie.RendezVous.entities;

import jakarta.persistence.*;
import ma.ac.uit.fs.kinesitherapie.Auths.entities.AuthUsers;
import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;
import ma.ac.uit.fs.kinesitherapie.RendezVous.enums.Statut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRendezVous;
    private String numeroRendezVous;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private LocalDateTime dateRendezVous;
    private String observation;

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

    public LocalDateTime getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(LocalDateTime dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
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
    public  UUID getUuidRendezVous(){
        return uuidRendezVous;
    }
    public  void setUuidRendezVous(UUID uuidRendezVous){
        this.uuidRendezVous = uuidRendezVous;
    }
    public Statut getStatut(){return statut;}
    public void setStatut(Statut statut){this.statut = statut;}
}
