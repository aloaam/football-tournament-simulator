package com.example.footballtournamentsimulator.points;

import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.team.TeamService;
import lombok.extern.slf4j.Slf4j;

/**
 * This component updates the points of the teams for different match days.
 */
@Slf4j
public class TeamPointsUpdater {

    private final MatchRepository matchRepository;
    private final TeamService teamService;


    public TeamPointsUpdater(MatchRepository matchRepository, TeamService teamService) {
        this.matchRepository = matchRepository;
        this.teamService = teamService;
    }

    /**
     * Update the points of the teams given all the available match-days.
     */
    public void update() {
        matchRepository.fetchAllMatches()
                .forEach(teamService::updatePointsFor);
    }

    /**
     * Updates the points of the teams up to the given match-day (inclusive).
     *
     * @param matchDay ceiling match day.
     */
    public void update(int matchDay) {
        matchRepository.fetchMatchesUpToMatchDay(matchDay).forEach(teamService::updatePointsFor);
    }

}