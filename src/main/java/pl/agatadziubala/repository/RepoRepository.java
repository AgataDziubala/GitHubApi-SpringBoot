package pl.agatadziubala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.agatadziubala.domain.Repo;

public interface RepoRepository extends JpaRepository<Repo, Long> {

    Repo findByFullName(String fullName);
    boolean existsByFullName(String fullName);

}
