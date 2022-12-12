package com.example.footballtournamentsimulator.tournamentgroup;

import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * This component contains methods to get input for visual representation of the group status.
 */
public class TournamentGroupVisualizer {

    private final TeamRepository teamRepository;
    private final TournamentGroupRepository groupRepository;

    public TournamentGroupVisualizer(TeamRepository teamRepository, TournamentGroupRepository groupRepository) {
        this.teamRepository = teamRepository;
        this.groupRepository = groupRepository;
    }

    public List<Team> getGroupsPointsBy(TournamentGroupName groupName) {
        final TournamentGroup group = groupRepository.getTournamentGroupByName(groupName);
        return teamRepository.getTeamByTournamentGroupId(
                group.getId(),
                Sort.by("points").descending());
    }
}
