package com.example.footballtournamentsimulator.simulator.simulatedteams;

/**
 * This object mimics the {@link com.example.footballtournamentsimulator.team.Team}, but is used
 * in the simulator to avoid updating the DB.
 */
public record TeamForSimulation(int points, String teamName, long tournamentGroupId) {
}
