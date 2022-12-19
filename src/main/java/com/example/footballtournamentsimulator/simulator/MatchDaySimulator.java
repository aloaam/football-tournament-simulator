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

import static com.example.footballtournamentsimulator.match.MatchPoints.TIE;
import static com.example.footballtournamentsimulator.match.MatchPoints.WIN;

public class MatchDaySimulator {

    private final PossibleMatchOutcomesService possibleMatchOutcomesService;
    private final TeamForSimulationService teamForSimulationService;
    private final MatchDayService service;

    public MatchDaySimulator(PossibleMatchOutcomesService possibleMatchOutcomesService, TeamForSimulationService teamForSimulationService, MatchDayService service) {
        this.possibleMatchOutcomesService = possibleMatchOutcomesService;
        this.teamForSimulationService = teamForSimulationService;
        this.service = service;
    }


    public HomeAwayMatchesFromMatchDaySimulator getMatchDayPossibleOutcomeByGroupAndMatchDay(TournamentGroupName groupName, int matchDay) {

        final MatchDay matches = service.getMatchDayByGroupAndId(groupName, matchDay);
        final List<PossibleGroupOutcomes> possibleOutcomes = possibleMatchOutcomesService.getAllPossibleOutcomesForADayMatch();


        final HomeAwayMatchesFromMatchDay homeAwayMatches = new HomeAwayMatchesFromMatchDay(matches);
        final HomeAwayMatchesFromMatchDaySimulator homeAndAwayTeams = new HomeAwayMatchesFromMatchDaySimulator(homeAwayMatches, teamForSimulationService);

        possibleOutcomes
                .forEach(outcome -> updatePoints(outcome, homeAndAwayTeams));
        return homeAndAwayTeams;

    }

    //TODO: Alo - te quedaste aquí, el grupo C está mal, porque polonia, aparece como que gana el último partido.
//        aparte, hay que ver como regresar un alista de partidos, con todos los outcomes.

    private void updatePoints(PossibleGroupOutcomes outcomes, HomeAwayMatchesFromMatchDaySimulator homeAwayMatches) {
        updatePointsSingleMatch(outcomes.outcome1(), homeAwayMatches.getMatch1HomeTeam(), homeAwayMatches.getMatch1AwayTeam());
        updatePointsSingleMatch(outcomes.outcome2(), homeAwayMatches.getMatch2HomeTeam(), homeAwayMatches.getMatch2AwayTeam());
    }

    private void updatePointsSingleMatch(MatchOutcome outcome, TeamForSimulation homeTeam, TeamForSimulation awayTeam) {

        if (outcome.equals(MatchOutcome.HOME_TEAM_WIN)) {
            teamForSimulationService.updatePoints(homeTeam, WIN);
            return;
        }
        if (outcome.equals(MatchOutcome.AWAY_TEAM_WIN)) {
            teamForSimulationService.updatePoints(awayTeam, WIN);
            return;
        }
        if (outcome.equals(MatchOutcome.TIE)) {
            teamForSimulationService.updatePoints(homeTeam, TIE);
            teamForSimulationService.updatePoints(awayTeam, TIE);
        }
    }


}
