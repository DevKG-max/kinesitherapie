package ma.ac.uit.fs.kinesitherapie.Patients.entities;

import jakarta.persistence.*;
import ma.ac.uit.fs.kinesitherapie.Auths.entities.AuthUsers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private UUID uuidPatient;
    private LocalDate dateNaissance;
    @ManyToOne
    @JoinColumn(name = "user_creation", nullable = false)
    private AuthUsers userCreation;

    private LocalDateTime dateCreation;

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public UUID getUuidPatient() {
        return uuidPatient;
    }

    public void setUuidPatient(UUID uuidPatient) {
        this.uuidPatient = uuidPatient;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
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
