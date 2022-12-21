package com.example.footballtournamentsimulator.simulator.simulatedteams;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This object mimics the {@link com.example.footballtournamentsimulator.actualdata.team.Team}, but is used
 * in the simulator to avoid updating the DB.
 */
@Getter
@Setter
@ToString
public class TeamForSimulation implements Cloneable {

    private long id;
    private int points;
    private String teamName;
    private long tournamentGroupId;

    /**
     * Creates a copy from an existing object.
     *
     * @param another object to copy.
     * @return clone of TeamForSimulation
     */
    public static TeamForSimulation from(TeamForSimulation another) {
        return new TeamForSimulation(
                another.id,
                another.points,
                another.teamName,
                another.getTournamentGroupId()
        );
    }

    public TeamForSimulation(long id, int points, String teamName, long tournamentGroupId) {
        this.id = id;
        this.points = points;
        this.teamName = teamName;
        this.tournamentGroupId = tournamentGroupId;
    }
}
