package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulation;

public record HomeAwayMatchesFromMatchDaySimulator(

        TeamForSimulation match1HomeTeam,
        TeamForSimulation match1AwayTeam,
        TeamForSimulation match2HomeTeam,
        TeamForSimulation match2AwayTeam) {

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
