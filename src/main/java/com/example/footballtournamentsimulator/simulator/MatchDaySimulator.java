package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.match.MatchResult;
import com.example.footballtournamentsimulator.matchday.HomeAwayMatchesFromMatchDay;
import com.example.footballtournamentsimulator.matchday.MatchDay;
import com.example.footballtournamentsimulator.matchday.MatchDayService;
import com.example.footballtournamentsimulator.simulator.outcomes.PossibleMatchOutcomes;
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


    public List<TeamForSimulation> getMatchDayPossibleOutcomeByGroupAndMatchDay(TournamentGroupName groupName, int matchDay) {

        final MatchDay matches = service.getMatchDayByGroupAndId(groupName, matchDay);
        final List<PossibleMatchOutcomes> possibleOutcomes = possibleMatchOutcomesService.getAllPossibleOutcomesForADayMatch();


        for (PossibleMatchOutcomes outcome : possibleOutcomes) {


            final HomeAwayMatchesFromMatchDay homeAwayMatches = new HomeAwayMatchesFromMatchDay(matches);
            final HomeAwayMatchesFromMatchDaySimulator m = new HomeAwayMatchesFromMatchDaySimulator(homeAwayMatches, teamForSimulationService);//TODO: Alo - change variable

            //-----
            final MatchResult matchResult1 = outcome.result1();
            final MatchResult matchResult2 = outcome.result2();


            if (matchResult1.equals(MatchResult.HOME_TEAM_WIN)) {
                m.getMatch1HomeTeam().updatePoints(WIN);
            }

            if (matchResult1.equals(MatchResult.AWAY_TEAM_WIN)) {
                m.getMatch1AwayTeam().updatePoints(WIN);
            }

            if (matchResult1.equals(MatchResult.TIE)) {
                m.getMatch2AwayTeam().updatePoints(TIE);
                m.getMatch2HomeTeam().updatePoints(TIE);
            }


        }


        return null; //TODO: ALO -

    }

}
