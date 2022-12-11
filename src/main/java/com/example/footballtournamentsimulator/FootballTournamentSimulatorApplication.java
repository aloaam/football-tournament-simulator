
package com.example.footballtournamentsimulator;

import com.example.footballtournamentsimulator.match.MatchGenerator;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.match.MatchResultsGenerator;
import com.example.footballtournamentsimulator.team.TeamPointsUpdater;
import com.example.footballtournamentsimulator.team.TeamRepository;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupGenerator;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballTournamentSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballTournamentSimulatorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            TeamRepository teamRepository,
            MatchRepository matchRepository,
            TournamentGroupRepository tournamentGroupRepository
            ) {
        return args -> {

            TournamentGroupGenerator tournamentGroupGenerator = new TournamentGroupGenerator(teamRepository);
            tournamentGroupGenerator.generateTournamentGroups();

            MatchGenerator matchGenerator = new MatchGenerator(matchRepository, teamRepository, tournamentGroupRepository);
            matchGenerator.generateMatches();

            MatchResultsGenerator matchResultsGenerator = new MatchResultsGenerator(teamRepository, matchRepository);
            matchResultsGenerator.generateMatchResults();

            TeamPointsUpdater teamPointsUpdater = new TeamPointsUpdater(teamRepository, matchRepository, tournamentGroupRepository);
            teamPointsUpdater.updatePoints();

        };

    }
}
