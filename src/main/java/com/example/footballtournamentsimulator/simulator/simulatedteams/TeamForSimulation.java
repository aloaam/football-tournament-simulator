package com.example.footballtournamentsimulator.simulator.simulatedteams;

import lombok.Getter;

/**
 * This object mimics the {@link com.example.footballtournamentsimulator.team.Team}, but is used
 * in the simulator to avoid updating the DB.
 */
@Getter
public class TeamForSimulation {

    private final long id;
    private final String teamName;
    private final long tournamentGroupId;
    private int points;

    public TeamForSimulation(long id, int points, String teamName, long tournamentGroupId) {
        this.id = id;
        this.points = points;
        this.teamName = teamName;
        this.tournamentGroupId = tournamentGroupId;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
