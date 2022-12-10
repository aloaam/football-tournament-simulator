package com.example.footballtournamentsimulator;

import com.example.footballtournamentsimulator.match.Match;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.match.MatchResult;
import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamName;
import com.example.footballtournamentsimulator.team.TeamPointsUpdater;
import com.example.footballtournamentsimulator.team.TeamRepository;
import com.example.footballtournamentsimulator.tournamentgroup.GroupName;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FootballTournamentSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballTournamentSimulatorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            TeamRepository teamRepository,
            MatchRepository matchRepository
            ) {
        return args -> {



            final TournamentGroup groupC = new TournamentGroup(GroupName.C);
            final Team argentina = new Team(TeamName.ARGENTINA, 3, groupC);
            final Team mexico = new Team(TeamName.MEXICO, 4, groupC);
            final Team poland = new Team(TeamName.POLAND, 1, groupC);
            final Team saudi_arabia = new Team(TeamName.SAUDI_ARABIA, 3, groupC);

            teamRepository.saveAll(List.of(argentina, mexico, poland, saudi_arabia));
            teamRepository.findAll().forEach(System.out::println);

            new TournamentGroup();

            final Match match1 = new Match(argentina, saudi_arabia, 1, MatchResult.AWAY_TEAM_WIN);
            final Match match2 = new Match(mexico, poland, 1, MatchResult.TIE);
            final Match match3 = new Match(argentina, mexico, 2, MatchResult.HOME_TEAM_WIN);
            final Match match4 = new Match(saudi_arabia, poland, 2, MatchResult.AWAY_TEAM_WIN);
            final Match match5 = new Match(argentina, poland, 3);
            final Match match6 = new Match(mexico, saudi_arabia, 3);
            matchRepository.saveAll(List.of(match1, match2, match3, match4, match5, match6));

            matchRepository.findMatchesByMatchDay(3).ifPresentOrElse(
                    matches -> matches.forEach(System.out::println),
                    () -> System.out.println("There are no matches on match day 3") );

            final TeamPointsUpdater teamPointsUpdater = new TeamPointsUpdater(teamRepository);

            teamPointsUpdater.updatePoints(match5, MatchResult.HOME_TEAM_WIN);

            teamRepository.updateTeamPoints(400, 1);


        };
    }


}
