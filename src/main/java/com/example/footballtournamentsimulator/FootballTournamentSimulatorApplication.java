
package com.example.footballtournamentsimulator;

import com.example.footballtournamentsimulator.datagenerator.FootballDataGenerator;
import com.example.footballtournamentsimulator.datagenerator.MatchGenerator;
import com.example.footballtournamentsimulator.datagenerator.MatchResultsGenerator;
import com.example.footballtournamentsimulator.datagenerator.TournamentGroupGenerator;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.match.MatchService;
import com.example.footballtournamentsimulator.points.TeamPointsUpdater;
import com.example.footballtournamentsimulator.team.TeamRepository;
import com.example.footballtournamentsimulator.team.TeamService;
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
            generateData(teamRepository, matchRepository, tournamentGroupRepository);
            updatePoints(teamRepository, matchRepository);
        };

    }

    private void updatePoints(TeamRepository teamRepository, MatchRepository matchRepository) {
        TeamPointsUpdater teamPointsUpdater = new TeamPointsUpdater(matchRepository, new TeamService(teamRepository, new MatchService()));
        teamPointsUpdater.update();
    }

    private void generateData(TeamRepository teamRepository, MatchRepository matchRepository, TournamentGroupRepository tournamentGroupRepository) {
        MatchGenerator matchGenerator = new MatchGenerator(matchRepository, teamRepository, tournamentGroupRepository);
        MatchResultsGenerator matchResultsGenerator = new MatchResultsGenerator(teamRepository, matchRepository);
        TournamentGroupGenerator tournamentGroupGenerator = new TournamentGroupGenerator(teamRepository);

        final FootballDataGenerator footballDataGenerator = new FootballDataGenerator(matchGenerator, matchResultsGenerator, tournamentGroupGenerator);
        footballDataGenerator.generate();
    }
}
