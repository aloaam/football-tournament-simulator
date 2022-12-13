package com.example.footballtournamentsimulator.tournamentgroup;

import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/groups")
public class TournamentGroupController {

    private final TeamRepository teamRepository;
    private final TournamentGroupRepository groupRepository;

    public TournamentGroupController(TeamRepository teamRepository, TournamentGroupRepository groupRepository) {
        this.teamRepository = teamRepository;
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public List<Team> getGroupsPointsBy(TournamentGroupName groupName) {
        final TournamentGroup group = groupRepository.getTournamentGroupByName(TournamentGroupName.A);
        return teamRepository.getTeamByTournamentGroupId(
                group.getId(),
                Sort.by("points").descending());
    }
}
