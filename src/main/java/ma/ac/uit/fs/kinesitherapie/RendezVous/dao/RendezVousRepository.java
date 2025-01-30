package ma.ac.uit.fs.kinesitherapie.RendezVous.dao;

import ma.ac.uit.fs.kinesitherapie.RendezVous.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

    List<RendezVous> findByDate(LocalDate date);
    List<RendezVous> findByPatient(Long idPatient);
}
