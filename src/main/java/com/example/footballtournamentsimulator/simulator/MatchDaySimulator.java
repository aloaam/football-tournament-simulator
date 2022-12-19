package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.match.MatchOutcome;
import com.example.footballtournamentsimulator.matchday.HomeAwayMatchesFromMatchDay;
import com.example.footballtournamentsimulator.matchday.MatchDay;
import com.example.footballtournamentsimulator.matchday.MatchDayService;
import com.example.footballtournamentsimulator.simulator.outcomes.PossibleGroupOutcomes;
import com.example.footballtournamentsimulator.simulator.outcomes.PossibleMatchOutcomesService;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulation;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulationService;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.footballtournamentsimulator.match.MatchOutcome.AWAY_TEAM_WIN;
import static com.example.footballtournamentsimulator.match.MatchOutcome.HOME_TEAM_WIN;
import static com.example.footballtournamentsimulator.match.MatchPoints.TIE;
import static com.example.footballtournamentsimulator.match.MatchPoints.WIN;

public class MatchDaySimulator {

    private final PossibleMatchOutcomesService possibleMatchOutcomesService;
    private final TeamForSimulationService teamForSimulationService;
    private final MatchDayService service;
    private final HomeAwayMatchesFromMatchDaySimulatorService homeAwayMatchesService;

    public MatchDaySimulator(PossibleMatchOutcomesService possibleMatchOutcomesService, TeamForSimulationService teamForSimulationService, MatchDayService service, HomeAwayMatchesFromMatchDaySimulatorService homeAwayMatchesService) {
        this.possibleMatchOutcomesService = possibleMatchOutcomesService;
        this.teamForSimulationService = teamForSimulationService;
        this.service = service;
        this.homeAwayMatchesService = homeAwayMatchesService;
    }


    public List<HomeAwayMatchesFromMatchDaySimulator> getMatchDayPossibleOutcomeByGroupAndMatchDay(TournamentGroupName groupName, int matchDay) {

        final MatchDay matches = service.getMatchDayByGroupAndId(groupName, matchDay);
        final List<PossibleGroupOutcomes> possibleOutcomes = possibleMatchOutcomesService.getAllPossibleOutcomesForADayMatch();


        HomeAwayMatchesFromMatchDaySimulator homeAndAwayTeams = homeAwayMatchesService.createFrom(new HomeAwayMatchesFromMatchDay(matches));

//        possibleOutcomes
//                .forEach(outcome -> updatePoints(outcome, homeAndAwayTeams));

        return possibleOutcomes.stream()
                .map(outcome -> updatePoints(outcome, homeAndAwayTeams))
                .collect(Collectors.toList());



    }

    private HomeAwayMatchesFromMatchDaySimulator updatePoints(PossibleGroupOutcomes outcomes, HomeAwayMatchesFromMatchDaySimulator homeAwayMatches) {
        HomeAwayMatchesFromMatchDaySimulator matches = new HomeAwayMatchesFromMatchDaySimulator(
                TeamForSimulation.from(homeAwayMatches.match1HomeTeam()),
                TeamForSimulation.from(homeAwayMatches.match1AwayTeam()),
                TeamForSimulation.from(homeAwayMatches.match2HomeTeam()),
                TeamForSimulation.from(homeAwayMatches.match2AwayTeam())
        );
        TeamForSimulation match1HomeTeam = matches.match1HomeTeam();
        TeamForSimulation match1AwayTeam = matches.match1AwayTeam();
        TeamForSimulation match2HomeTeam = matches.match2HomeTeam();
        TeamForSimulation match2AwayTeam = matches.match2AwayTeam();

        updatePointsSingleMatch(outcomes.outcome1(), match1HomeTeam, match1AwayTeam);
        updatePointsSingleMatch(outcomes.outcome2(), match2HomeTeam, match2AwayTeam);

        return matches;
    }

    private void updatePointsSingleMatch(MatchOutcome outcome, TeamForSimulation homeTeam, TeamForSimulation awayTeam) {

        if (outcome.equals(HOME_TEAM_WIN)) {
            teamForSimulationService.updatePoints(homeTeam, WIN);
            return;
        }
        if (outcome.equals(AWAY_TEAM_WIN)) {
            teamForSimulationService.updatePoints(awayTeam, WIN);
            return;
        }
        if (outcome.equals(MatchOutcome.TIE)) {
            teamForSimulationService.updatePoints(homeTeam, TIE);
            teamForSimulationService.updatePoints(awayTeam, TIE);
        }
    }
}
