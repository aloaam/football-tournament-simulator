package com.example.footballtournamentsimulator.simulator.matchdaysimulator;

import com.example.footballtournamentsimulator.actualdata.match.MatchOutcome;
import com.example.footballtournamentsimulator.actualdata.matchday.GroupMatchSimulationService;
import com.example.footballtournamentsimulator.actualdata.matchday.MatchDay;
import com.example.footballtournamentsimulator.actualdata.matchday.MatchDayService;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupName;
import com.example.footballtournamentsimulator.simulator.grroupmatchday.GroupMatchDay;
import com.example.footballtournamentsimulator.simulator.grroupmatchday.GroupMatchDaySimulation;
import com.example.footballtournamentsimulator.simulator.grroupmatchday.MatchWithOutcome;
import com.example.footballtournamentsimulator.simulator.outcomes.PossibleGroupOutcomes;
import com.example.footballtournamentsimulator.simulator.outcomes.PossibleMatchOutcomesService;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulation;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulationService;

import java.util.List;

import static com.example.footballtournamentsimulator.actualdata.match.MatchOutcome.AWAY_TEAM_WIN;
import static com.example.footballtournamentsimulator.actualdata.match.MatchOutcome.HOME_TEAM_WIN;
import static com.example.footballtournamentsimulator.actualdata.match.MatchPoints.TIE;
import static com.example.footballtournamentsimulator.actualdata.match.MatchPoints.WIN;

public class MatchDaySimulator {

    private final PossibleMatchOutcomesService possibleMatchOutcomesService;
    private final TeamForSimulationService teamForSimulationService;
    private final MatchDayService service;
    private final GroupMatchSimulationService homeAwayMatchesService;

    public MatchDaySimulator(PossibleMatchOutcomesService possibleMatchOutcomesService, TeamForSimulationService teamForSimulationService, MatchDayService service, GroupMatchSimulationService homeAwayMatchesService) {
        this.possibleMatchOutcomesService = possibleMatchOutcomesService;
        this.teamForSimulationService = teamForSimulationService;
        this.service = service;
        this.homeAwayMatchesService = homeAwayMatchesService;
    }


    public List<GroupMatchDaySimulation> getMatchDayPossibleOutcomeByGroupAndMatchDay(TournamentGroupName groupName, int matchDay) {

        final MatchDay matches = service.getMatchDayByGroupAndId(groupName, matchDay);
        final List<PossibleGroupOutcomes> possibleOutcomes = possibleMatchOutcomesService.getAllPossibleOutcomesForADayMatch();


        GroupMatchDaySimulation groupMatchDaySimulation = homeAwayMatchesService.createFrom(new GroupMatchDay(matches));

        return possibleOutcomes.stream()
                .map(outcome -> updatePoints(groupName, outcome, groupMatchDaySimulation))
                .toList();
    }

    private GroupMatchDaySimulation updatePoints(TournamentGroupName groupName, PossibleGroupOutcomes outcomes, GroupMatchDaySimulation groupMatchDaySimulation) {


        GroupMatchDaySimulation matches = new GroupMatchDaySimulation(
                groupName,
                new MatchWithOutcome(
                        TeamForSimulation.from(groupMatchDaySimulation.match1().getHomeTeam()),
                        TeamForSimulation.from(groupMatchDaySimulation.match1().getAwayTeam())

                ),
                new MatchWithOutcome(
                        TeamForSimulation.from(groupMatchDaySimulation.match2().getHomeTeam()),
                        TeamForSimulation.from(groupMatchDaySimulation.match2().getAwayTeam())
                )
        );
        updatePointsSingleMatch(outcomes.outcome1(), matches.match1());
        updatePointsSingleMatch(outcomes.outcome2(), matches.match2());
        return matches;
    }

    private void updatePointsSingleMatch(MatchOutcome outcome, MatchWithOutcome matchWithOutcome) {

        matchWithOutcome.setOutcome(outcome);

        if (outcome.equals(HOME_TEAM_WIN)) {
            teamForSimulationService.updatePoints(matchWithOutcome.getHomeTeam(), WIN);
            return;
        }
        if (outcome.equals(AWAY_TEAM_WIN)) {
            teamForSimulationService.updatePoints(matchWithOutcome.getAwayTeam(), WIN);
            return;
        }
        if (outcome.equals(MatchOutcome.TIE)) {
            teamForSimulationService.updatePoints(matchWithOutcome.getHomeTeam(), TIE);
            teamForSimulationService.updatePoints(matchWithOutcome.getAwayTeam(), TIE);
        }
    }
}
