package ma.ac.uit.fs.kinesitherapie.RendezVous.services;

import ma.ac.uit.fs.kinesitherapie.RendezVous.entities.RendezVous;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface RendezVousService {
    RendezVous createRendezVous(RendezVous rendezVous);
    void annulerRendezVous (RendezVous rendezVous);
    void confirmerRendezVous(RendezVous rendezVous);
    RendezVous reporterRendezVous(RendezVous rendezVous);
    List<RendezVous> getRendezVousByDate(LocalDate date);
    List<RendezVous> getRendezVousByDateBetween(LocalDate dateDebut, LocalDate dateFin);
    List<RendezVous> getRendezVousByPatient(String patientName);
}
