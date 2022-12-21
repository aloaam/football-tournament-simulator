
package com.example.footballtournamentsimulator;

import com.example.footballtournamentsimulator.datagenerator.FootballDataGenerator;
import com.example.footballtournamentsimulator.datagenerator.MatchGenerator;
import com.example.footballtournamentsimulator.datagenerator.MatchResultsGenerator;
import com.example.footballtournamentsimulator.datagenerator.TournamentGroupGenerator;
import com.example.footballtournamentsimulator.exporter.CsvFileExporter;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.match.MatchService;
import com.example.footballtournamentsimulator.matchday.GroupMatchSimulationService;
import com.example.footballtournamentsimulator.matchday.MatchDayService;
import com.example.footballtournamentsimulator.points.TeamPointsUpdater;
import com.example.footballtournamentsimulator.simulator.grroupmatchday.GroupMatchDaySimulation;
import com.example.footballtournamentsimulator.simulator.matchdaysimulator.MatchDaySimulator;
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
import java.util.List;

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

            final Repositories repos = new Repositories(teamRepository, matchRepository, groupRepository);
            final MatchService matchService = new MatchService();

            final int matchDay = 5;
            generateData(repos);
            updatePoints(repos, matchDay);
//            printMatchSimulations(repos, TournamentGroupName.D, matchDay);
            printAllGroups(repos);

        };
    }

    private void printAllGroups(Repositories repos) {
        final MatchService matchService = new MatchService();
        final TeamService teamService = new TeamService(repos.teamRepository, matchService, repos.groupRepository);
        teamService.getTeamsGroupedByTournamentGroup()
                .forEach(System.out::println);
    }

    private List<GroupMatchDaySimulation> printMatchSimulations(Repositories repos, TournamentGroupName groupName, int matchDay) {
        TeamForSimulationService teamForSimulationService = new TeamForSimulationService(repos.groupRepository, repos.teamRepository);
        final MatchDaySimulator matchDaySimulator = new MatchDaySimulator(new PossibleMatchOutcomesService(),
                teamForSimulationService,
                new MatchDayService(repos.groupRepository, repos.matchRepository),
                new GroupMatchSimulationService(teamForSimulationService));

        List<GroupMatchDaySimulation> simulations = matchDaySimulator.getMatchDayPossibleOutcomeByGroupAndMatchDay(groupName, matchDay + 1);
        simulations.forEach(System.out::println);
        return simulations;
    }

    private void exportCsv(TeamRepository teamRepository, TournamentGroupRepository tournamentGroupRepository) throws IOException {
        new CsvFileExporter(new TeamService(teamRepository, new MatchService(), tournamentGroupRepository)).export();
    }

    private void updatePoints(Repositories repos, int matchDay) {
        final TeamService teamService = new TeamService(repos.teamRepository, new MatchService(), repos.groupRepository);
        TeamPointsUpdater teamPointsUpdater = new TeamPointsUpdater(repos.matchRepository, teamService);
        teamPointsUpdater.update(matchDay);
    }

    private void generateData(Repositories repos) {
        MatchGenerator matchGenerator = new MatchGenerator(repos.matchRepository, repos.teamRepository, repos.groupRepository);
        MatchResultsGenerator matchResultsGenerator = new MatchResultsGenerator(repos.teamRepository, repos.matchRepository);
        TournamentGroupGenerator tournamentGroupGenerator = new TournamentGroupGenerator(repos.teamRepository);

        final FootballDataGenerator footballDataGenerator = new FootballDataGenerator(matchGenerator, matchResultsGenerator, tournamentGroupGenerator);
        footballDataGenerator.generate();
    }

    private record Repositories(TeamRepository teamRepository, MatchRepository matchRepository,
                                TournamentGroupRepository groupRepository) {
    }

}
