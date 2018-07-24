package pl.agatadziubala.service;

import pl.agatadziubala.domain.Gist;
import pl.agatadziubala.domain.Person;
import pl.agatadziubala.dto.RepoDto;

import java.util.List;

public interface GithubService {

    int howManyFollowersThePersonHas(String login);
    int howManyReposThePersonHas(String login);
    String howManyDaysAgoTheAccountWasCreated(String login);
    Double averageNoOfFollowersOfFollowers(String login);
    Double averageNoOfFollowersRepos(String login);
    List<Gist> gistsOfAUSer(String login);
    List<Gist> gistsWhichDescriptionContainsWord(String login, String word);
    List<RepoDto> reposOfAUser(String login);
    List<RepoDto> reposOfAUserWhichAreForks(String login);
    List<RepoDto> reposWrittenMostlyInASpecificLanguage(String login, String language);
    List<Person> followersOfAUser(String login);
}
