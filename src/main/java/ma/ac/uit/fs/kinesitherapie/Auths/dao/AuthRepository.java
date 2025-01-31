package ma.ac.uit.fs.kinesitherapie.Auths.dao;

import ma.ac.uit.fs.kinesitherapie.Auths.entities.AuthUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface  AuthRepository extends JpaRepository<AuthUsers,Long> {
    Optional<AuthUsers> findByUsername(String username);
    AuthUsers findByUuidUser(String uuidUser);
}
