package com.example.footballtournamentsimulator.match;

import org.springframework.stereotype.Service;

import static com.example.footballtournamentsimulator.match.MatchOutcome.*;

@Service
public class MatchService {

    /**
     * Evaluates the result of a match.
     *
     * @param match for which the result will be evaluated.
     * @return the corresponding MatchResult.
     */
    public MatchOutcome getMatchResult(Match match) {
        int homeTeamGoals = match.getHomeTeamGoals();
        int awayTeamGoals = match.getAwayTeamGoals();

        if (homeTeamGoals > awayTeamGoals) return HOME_TEAM_WIN;
        if (awayTeamGoals > homeTeamGoals) return AWAY_TEAM_WIN;
        return TIE;
    }

//    public int getNextMatchDay() {
//        String name = MAX_MATCH_DAY.MAX_MATCH_DAY.name();//TODO: ALO -
//    }
}
