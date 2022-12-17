package com.example.footballtournamentsimulator.match;

import org.springframework.stereotype.Service;

import static com.example.footballtournamentsimulator.match.MatchResult.*;

@Service
public class MatchService {

    /**
     * Evaluates the result of a match.
     *
     * @param match for which the result will be evaluated.
     * @return the corresponding MatchResult.
     */
    public MatchResult getMatchResult(Match match) {
        int homeTeamGoals = match.getHomeTeamGoals();
        int awayTeamGoals = match.getAwayTeamGoals();

        if (homeTeamGoals > awayTeamGoals) return HOME_TEAM_WIN;
        if (awayTeamGoals > homeTeamGoals) return AWAY_TEAM_WIN;
        return TIE;
    }
}
