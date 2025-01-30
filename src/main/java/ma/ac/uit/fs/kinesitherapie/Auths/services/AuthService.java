package ma.ac.uit.fs.kinesitherapie.Auths.services;

import ma.ac.uit.fs.kinesitherapie.Auths.dao.AuthRepository;
import ma.ac.uit.fs.kinesitherapie.Auths.entities.AuthUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public Optional<AuthUsers> findByUsername(String username) {
        return authRepository.findByUsername(username);
    }

    public AuthUsers createUser(AuthUsers user) {
        return authRepository.save(user);
    }

    public void deleteUser(Long id) {
        authRepository.deleteById(id);
    }
    public void ResetPassword(HashMap data) {
        //authRepository.deleteById(id);
    }
    public AuthUsers getUserByUuid(String uuidUser){
        return authRepository.findByUuidUser(uuidUser).orElse(null);
    }
}
