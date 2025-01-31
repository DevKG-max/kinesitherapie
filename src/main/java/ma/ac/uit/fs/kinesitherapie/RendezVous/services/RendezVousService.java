package ma.ac.uit.fs.kinesitherapie.RendezVous.services;

import ma.ac.uit.fs.kinesitherapie.Patients.dto.RendezVousPatientDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dto.RendezVousDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dto.RendezVousObjectDto;
import ma.ac.uit.fs.kinesitherapie.RendezVous.entities.RendezVous;
import ma.ac.uit.fs.kinesitherapie.utils.ResponseData;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface RendezVousService {
    ResponseData createRendezVous(RendezVousObjectDto data);
    void annulerRendezVous (RendezVous rendezVous);
    void confirmerRendezVous(RendezVous rendezVous);
    RendezVous reporterRendezVous(RendezVous rendezVous);
    List<RendezVous> getRendezVousByDate(LocalDate date);
    List<RendezVous> getRendezVousByDateBetween(LocalDate dateDebut, LocalDate dateFin);
    List<RendezVous> getRendezVousByPatient(String patientName);

    RendezVousDto getRendezVous(UUID uuidRendezVous);
    List<RendezVousPatientDto> getRendezVousPatient( UUID uuidPatient);
}
