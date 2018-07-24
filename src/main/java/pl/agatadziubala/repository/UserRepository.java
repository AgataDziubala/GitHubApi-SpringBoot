package pl.agatadziubala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.agatadziubala.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    boolean existsByLogin(String login);
}
