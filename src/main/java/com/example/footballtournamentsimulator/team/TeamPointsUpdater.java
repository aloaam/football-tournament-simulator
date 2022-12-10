package com.example.footballtournamentsimulator.team;

import com.example.footballtournamentsimulator.match.Match;
import com.example.footballtournamentsimulator.match.MatchPoints;
import com.example.footballtournamentsimulator.match.MatchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.footballtournamentsimulator.match.MatchResult.*;


@Slf4j
public class TeamPointsUpdater {

    private TeamRepository teamRepository;

    @Autowired
    public TeamPointsUpdater(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void updatePoints(Match match, MatchResult matchResult) {

        //TODO: Alo - use a design pattern here.
        if (matchResult.equals(AWAY_TEAM_WIN) || matchResult.equals(HOME_TEAM_WIN)) {
            updatePointsForAWin(match, matchResult);
        }

        if (matchResult.equals(TIE)) {
            updatePointsForTie(match);
        }
    }

    private void updatePointsForAWin(Match match, MatchResult matchResult) {
        final Team winnerTeam = match.getWinnerTeam(matchResult);
        final int newPoints = winnerTeam.getPoints() + MatchPoints.WIN.points;
        teamRepository.updateTeamPoints(newPoints, winnerTeam.getId());
    }

    private void updatePointsForTie(Match match) {
        final Team homeTeam = match.getHomeTeam();
        teamRepository.updateTeamPoints(homeTeam.getPoints() + MatchPoints.TIE.points, homeTeam.getId());

        final Team awayTeam = match.getAwayTeam();
        teamRepository.updateTeamPoints(awayTeam.getPoints() + MatchPoints.TIE.points, awayTeam.getId());

    }


}