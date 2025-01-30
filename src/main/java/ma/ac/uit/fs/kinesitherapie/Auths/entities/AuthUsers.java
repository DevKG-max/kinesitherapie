package ma.ac.uit.fs.kinesitherapie.Auths.entities;

import jakarta.persistence.*;
import ma.ac.uit.fs.kinesitherapie.Patients.entities.Patients;

import java.util.ArrayList;
import java.util.List;
@Entity
public class AuthUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;
    private String displayName;
    private String password;
    private String uuidUser;

    public Long getIdUser() {
        return idUser;
    }

    public void setId_user(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(String uuidUser) {
        this.uuidUser = uuidUser;
    }
}
