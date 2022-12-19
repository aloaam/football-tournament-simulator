package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulation;

public record HomeAwayMatchesFromMatchDaySimulator(

        TeamForSimulation match1HomeTeam,
        TeamForSimulation match1AwayTeam,
        TeamForSimulation match2HomeTeam,
        TeamForSimulation match2AwayTeam) {

    //TODO: ALO - create another object to hold the outcome and the matches. Or maybe in this same one, bu
    // the one which is not for simulation, shouldnt have it.
    @Override
    public String toString() {
        return "Group: ..." + "\n" +
                "Outcome Match 1: ..." + "\n" +
                "Outcome Match 2: ..." + "\n" +
                "match1HomeTeam=" + match1HomeTeam + "\n" +
                "match1AwayTeam=" + match1AwayTeam + "\n" +
                "match2HomeTeam=" + match2HomeTeam + "\n" +
                "match2AwayTeam=" + match2AwayTeam + "\n";
    }
}
