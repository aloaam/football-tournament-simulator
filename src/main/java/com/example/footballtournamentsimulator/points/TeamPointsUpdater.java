package com.example.footballtournamentsimulator.points;

import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.team.TeamService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeamPointsUpdater implements PointsUpdater {

    private final MatchRepository matchRepository;
    private final TeamService teamService;


    public TeamPointsUpdater(MatchRepository matchRepository, TeamService teamService) {
        this.matchRepository = matchRepository;
        this.teamService = teamService;
    }

    /**
     * Updates all matches
     */
    @Override
    public void update() {
        matchRepository.fetchAllMatches()
                .forEach(teamService::updatePointsFor);
    }


}