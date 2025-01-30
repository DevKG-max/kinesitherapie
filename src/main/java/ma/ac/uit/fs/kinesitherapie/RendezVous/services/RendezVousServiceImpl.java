package ma.ac.uit.fs.kinesitherapie.RendezVous.services;

import ma.ac.uit.fs.kinesitherapie.Auths.dao.AuthRepository;
import ma.ac.uit.fs.kinesitherapie.RendezVous.dao.RendezVousRepository;
import ma.ac.uit.fs.kinesitherapie.RendezVous.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RendezVousServiceImpl implements RendezVousService{
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private AuthRepository authRepository;

    public RendezVous createRendezVous(RendezVous rendezVous, String uuidUser) {
        rendezVous.setUserCreation(authRepository.findByUuidUser(uuidUser).get());
        rendezVous.setDateCreation(LocalDateTime.now());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous createRendezVous(RendezVous rendezVous) {
        return null;
    }

    @Override
    public void annulerRendezVous(RendezVous rendezVous) {

    }

    @Override
    public void confirmerRendezVous(RendezVous rendezVous) {

    }

    @Override
    public RendezVous reporterRendezVous(RendezVous rendezVous) {
        return null;
    }

    @Override
    public List<RendezVous> getRendezVousByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<RendezVous> getRendezVousByDateBetween(LocalDate dateDebut, LocalDate dateFin) {
        return null;
    }

    @Override
    public List<RendezVous> getRendezVousByPatient(String patientName) {
        return null;
    }
}

