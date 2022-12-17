package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.simulator.outcomes.PossibleMatchOutcomesService;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulation;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulationService;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName;

import java.util.List;

public class MatchDaySimulator {

    private final PossibleMatchOutcomesService possibleMatchOutcomesService;
    private final TeamForSimulationService simulatedTeamService;

    public MatchDaySimulator(PossibleMatchOutcomesService possibleMatchOutcomesService, TeamForSimulationService simulatedTeamService) {
        this.possibleMatchOutcomesService = possibleMatchOutcomesService;
        this.simulatedTeamService = simulatedTeamService;
    }


    public List<TeamForSimulation> getMatchDayPossibleOutcomeBy(TournamentGroupName groupName) {

        List<TeamForSimulation> teams = simulatedTeamService.getTeamsByGroupName(groupName);

        return null; //TODO: ALO -

    }






}
