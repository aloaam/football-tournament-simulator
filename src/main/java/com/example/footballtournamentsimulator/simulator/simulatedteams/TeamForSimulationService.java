package com.example.footballtournamentsimulator.simulator.simulatedteams;

import com.example.footballtournamentsimulator.actualdata.match.MatchPoints;
import com.example.footballtournamentsimulator.actualdata.team.Team;
import com.example.footballtournamentsimulator.actualdata.team.TeamRepository;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroup;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupName;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TeamForSimulationService {

    private final TournamentGroupRepository groupRepository;
    private final TeamRepository teamRepository;

    public TeamForSimulationService(TournamentGroupRepository groupRepository, TeamRepository teamRepository) {
        this.groupRepository = groupRepository;
        this.teamRepository = teamRepository;
    }

    public void updatePoints(TeamForSimulation team, MatchPoints matchPoints) {
        team.setPoints(team.getPoints() + matchPoints.points);
    }

    public List<TeamForSimulation> getTeamsByGroupName(TournamentGroupName groupName) {
        TournamentGroup group = groupRepository.getTournamentGroupByName(groupName);
        List<Team> teams = teamRepository.getTeamsByTournamentGroupId(group.getId());
        return convertTeams(teams);
    }

    public List<TeamForSimulation> convertTeams(List<Team> teams) {
        return teams.stream()
                .map(team -> new TeamForSimulation(
                        team.getId(),
                        team.getPoints(),
                        team.getTeamName().name(),
                        team.getTournamentGroupId().getId()))
                .collect(Collectors.toList());
    }

    public TeamForSimulation convertTeam(Team team) {
        return new TeamForSimulation(team.getId(),
                team.getPoints(),
                team.getTeamName().name(),
                team.getId());
    }
}
