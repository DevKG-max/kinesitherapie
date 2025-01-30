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
}
