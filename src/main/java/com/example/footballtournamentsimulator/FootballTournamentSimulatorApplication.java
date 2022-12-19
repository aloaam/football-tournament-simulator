
package com.example.footballtournamentsimulator;

import com.example.footballtournamentsimulator.datagenerator.FootballDataGenerator;
import com.example.footballtournamentsimulator.datagenerator.MatchGenerator;
import com.example.footballtournamentsimulator.datagenerator.MatchResultsGenerator;
import com.example.footballtournamentsimulator.datagenerator.TournamentGroupGenerator;
import com.example.footballtournamentsimulator.exporter.CsvFileExporter;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.match.MatchService;
import com.example.footballtournamentsimulator.matchday.MatchDayService;
import com.example.footballtournamentsimulator.points.TeamPointsUpdater;
import com.example.footballtournamentsimulator.simulator.MatchDaySimulator;
import com.example.footballtournamentsimulator.simulator.outcomes.PossibleMatchOutcomesService;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulationService;
import com.example.footballtournamentsimulator.team.TeamRepository;
import com.example.footballtournamentsimulator.team.TeamService;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class FootballTournamentSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballTournamentSimulatorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            TeamRepository teamRepository,
            MatchRepository matchRepository,
            TournamentGroupRepository groupRepository
    ) {
        return args -> {
            generateData(teamRepository, matchRepository, groupRepository);
            updatePoints(teamRepository, matchRepository, groupRepository);

            final MatchDaySimulator matchDaySimulator = new MatchDaySimulator(new PossibleMatchOutcomesService(),
                    new TeamForSimulationService(groupRepository, teamRepository),
                    new MatchDayService(groupRepository, matchRepository));

            matchDaySimulator.getMatchDayPossibleOutcomeByGroupAndMatchDay(TournamentGroupName.C, 3);
        };


    }

    private void exportCsv(TeamRepository teamRepository, TournamentGroupRepository tournamentGroupRepository) throws IOException {
        new CsvFileExporter(new TeamService(teamRepository, new MatchService(), tournamentGroupRepository)).export();
    }

    private void updatePoints(TeamRepository teamRepository, MatchRepository matchRepository, TournamentGroupRepository tournamentGroupRepository) {
        TeamPointsUpdater teamPointsUpdater = new TeamPointsUpdater(matchRepository, new TeamService(teamRepository, new MatchService(), tournamentGroupRepository));
        teamPointsUpdater.update(2);
    }

    private void generateData(TeamRepository teamRepository, MatchRepository matchRepository, TournamentGroupRepository tournamentGroupRepository) {
        MatchGenerator matchGenerator = new MatchGenerator(matchRepository, teamRepository, tournamentGroupRepository);
        MatchResultsGenerator matchResultsGenerator = new MatchResultsGenerator(teamRepository, matchRepository);
        TournamentGroupGenerator tournamentGroupGenerator = new TournamentGroupGenerator(teamRepository);

        final FootballDataGenerator footballDataGenerator = new FootballDataGenerator(matchGenerator, matchResultsGenerator, tournamentGroupGenerator);
        footballDataGenerator.generate();
    }
}
