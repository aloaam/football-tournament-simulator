package com.example.footballtournamentsimulator.matchday;

import com.example.footballtournamentsimulator.match.Match;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroup;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;

import java.util.List;

public class MatchDayService {


    private final TournamentGroupRepository groupRepository;
    private final MatchRepository matchRepository;

    public MatchDayService(TournamentGroupRepository groupRepository, MatchRepository matchRepository) {
        this.groupRepository = groupRepository;
        this.matchRepository = matchRepository;
    }

    public MatchDay getMatchDayByGroupAndId(TournamentGroupName groupName, int matchDay) {
        final TournamentGroup group = groupRepository.getTournamentGroupByName(groupName);

        final long groupId = group.getId();
        final List<Match> matches = matchRepository.fetchMatchesByMatchDayAndGroupId(matchDay, groupId);

        return MatchDay.from(matches);
    }


}
