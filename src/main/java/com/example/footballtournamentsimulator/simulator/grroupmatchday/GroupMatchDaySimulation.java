package com.example.footballtournamentsimulator.simulator.grroupmatchday;

import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupName;

/**
 * This object holds the information the outcome of a simulation for one match-day.
 */
public record GroupMatchDaySimulation(TournamentGroupName groupName, MatchWithOutcome match1, MatchWithOutcome match2) {

    @Override
    public String toString() {
        return "Group: " + groupName + "\n" +
                "Match 1 Outcome: " + match1.getOutcome() + "\n" +
                "Match 2 Outcome: " + match2.getOutcome() + "\n" +
                match1() + "\n" +
                match2() + "\n";
    }
}
