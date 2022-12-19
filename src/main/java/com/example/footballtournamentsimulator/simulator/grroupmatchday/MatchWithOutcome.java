package com.example.footballtournamentsimulator.simulator.grroupmatchday;

import com.example.footballtournamentsimulator.match.MatchOutcome;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulation;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MatchWithOutcome {

    private final TeamForSimulation homeTeam;
    private final TeamForSimulation awayTeam;
    private MatchOutcome outcome;


    public MatchWithOutcome(TeamForSimulation homeTeam, TeamForSimulation awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void setOutcome(MatchOutcome outcome) {
        this.outcome = outcome;
    }
}
