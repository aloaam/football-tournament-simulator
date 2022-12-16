package com.example.footballtournamentsimulator.team;

import com.example.footballtournamentsimulator.match.Match;
import com.example.footballtournamentsimulator.match.MatchPoints;
import com.example.footballtournamentsimulator.match.MatchResult;
import com.example.footballtournamentsimulator.match.MatchService;
import org.springframework.stereotype.Service;

import static com.example.footballtournamentsimulator.match.MatchResult.*;

@Service
public class TeamService {

    private final TeamRepository repository;
    private final MatchService matchService;

    public TeamService(TeamRepository repository, MatchService matchService) {
        this.repository = repository;
        this.matchService = matchService;
    }

    /**
     * Updates the points of the teams given a match (one team for a win/lose and two teams for a tie).
     *
     * @param match from which the teams' points will be updated.
     */
    public void updatePointsFor(Match match) {
        final MatchResult matchResult = matchService.getMatchResult(match);
        final Team homeTeam = match.getHomeTeam();
        final Team awayTeam = match.getAwayTeam();
        final int pointsForAWin = MatchPoints.WIN.points;
        final int pointsForATie = MatchPoints.TIE.points;
        final int homeTeamPoints = repository.getPointsByTeamId(homeTeam.getId());
        final int awayTeamPoints = repository.getPointsByTeamId(awayTeam.getId());

        if (matchResult.equals(HOME_TEAM_WIN)) {
            updateTeamPoints(homeTeam, homeTeamPoints + pointsForAWin);
            return;
        }
        if (matchResult.equals(AWAY_TEAM_WIN)) {
            updateTeamPoints(awayTeam, awayTeamPoints + pointsForAWin);
            return;
        }
        if (matchResult.equals(TIE)) {
            updateTeamPoints(homeTeam, homeTeamPoints + pointsForATie);
            updateTeamPoints(awayTeam, awayTeamPoints + pointsForATie);
        }
    }

    public void updateTeamPoints(Team team, int pointsToAdd) {
        repository.updateTeamPoints(pointsToAdd, team.getId());
    }
}
