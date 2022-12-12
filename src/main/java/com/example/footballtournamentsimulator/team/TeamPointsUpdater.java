package com.example.footballtournamentsimulator.team;

import com.example.footballtournamentsimulator.match.Match;
import com.example.footballtournamentsimulator.match.MatchPoints;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.match.MatchResult;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroup;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.example.footballtournamentsimulator.match.MatchResult.*;
import static com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName.C;


@Slf4j
public class TeamPointsUpdater {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final TournamentGroupRepository tournamentGroupRepository;

    public TeamPointsUpdater(TeamRepository teamRepository, MatchRepository matchRepository, TournamentGroupRepository tournamentGroupRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
        this.tournamentGroupRepository = tournamentGroupRepository;
    }

    public void updatePoints() {
        updatePointsGroupC();
    }

    private void updatePointsGroupC() {
        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(C);
        List<Match> matches = matchRepository.getMatchesByGroup(group.getId());
        matches.forEach(this::updatePoints);
    }

    private void updatePoints(Match match) {
        MatchResult matchResult = evaluateMatchResult(match);
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();

        if (matchResult.equals(HOME_TEAM_WIN)) {
            updatePointsForAWin(homeTeam);
            return;
        }
        if (matchResult.equals(AWAY_TEAM_WIN)) {
            updatePointsForAWin(awayTeam);
            return;
        }
        if (matchResult.equals(TIE)) {
            updatePointsForTie(homeTeam, awayTeam);
        }
    }

    private void updatePointsForAWin(Team team) {
        int currentPoints = teamRepository.getPointsByTeamId(team.getId());
        final int newPoints = currentPoints + MatchPoints.WIN.points;
        teamRepository.updateTeamPoints(newPoints, team.getId());
    }

    private void updatePointsForTie(Team homeTeam, Team awayTeam) {
        int pointsForTie = MatchPoints.TIE.points;

        int homeTeamCurrentPoints = teamRepository.getPointsByTeamId(homeTeam.getId());
        int awayTeamCurrentPoints = teamRepository.getPointsByTeamId(awayTeam.getId());
        teamRepository.updateTeamPoints(homeTeamCurrentPoints + pointsForTie, homeTeam.getId());
        teamRepository.updateTeamPoints(awayTeamCurrentPoints + pointsForTie, awayTeam.getId());
    }

    private MatchResult evaluateMatchResult(Match match) {
        int homeTeamGoals = match.getHomeTeamGoals();
        int awayTeamGoals = match.getAwayTeamGoals();

        if (homeTeamGoals > awayTeamGoals) return HOME_TEAM_WIN;
        if (awayTeamGoals > homeTeamGoals) return AWAY_TEAM_WIN;
        return TIE;
    }
}