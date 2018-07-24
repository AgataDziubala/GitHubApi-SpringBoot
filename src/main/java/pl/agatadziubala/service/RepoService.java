package pl.agatadziubala.service;

import pl.agatadziubala.domain.Repo;

import java.util.List;

public interface RepoService {
    void saveRepo(Repo repo);

    void deleteRepo(Repo repo);

    List<Repo> findAllRepos();

    void updateRepo(Repo repo);
}
