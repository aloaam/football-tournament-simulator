package com.example.footballtournamentsimulator.team;

import com.example.footballtournamentsimulator.match.Match;
import com.example.footballtournamentsimulator.match.MatchOutcome;
import com.example.footballtournamentsimulator.match.MatchPoints;
import com.example.footballtournamentsimulator.match.MatchService;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.footballtournamentsimulator.match.MatchOutcome.*;

@Service
public class TeamService {

    private final TeamRepository repository;
    private final MatchService matchService;
    private final TournamentGroupRepository groupRepository;

    public TeamService(TeamRepository repository, MatchService matchService, TournamentGroupRepository groupRepository) {
        this.repository = repository;
        this.matchService = matchService;
        this.groupRepository = groupRepository;
    }

    /**
     * Updates the points of the teams given a match (one team for a win/lose and two teams for a tie).
     *
     * @param match from which the teams' points will be updated.
     */
    public void updatePointsFor(Match match) {
        final MatchOutcome matchOutcome = matchService.getMatchResult(match);
        final Team homeTeam = match.getHomeTeam();
        final Team awayTeam = match.getAwayTeam();
        final int pointsForAWin = MatchPoints.WIN.points;
        final int pointsForATie = MatchPoints.TIE.points;
        final int homeTeamPoints = repository.getPointsByTeamId(homeTeam.getId());
        final int awayTeamPoints = repository.getPointsByTeamId(awayTeam.getId());

        if (matchOutcome.equals(HOME_TEAM_WIN)) {
            updateTeamPoints(homeTeam, homeTeamPoints + pointsForAWin);
            return;
        }
        if (matchOutcome.equals(AWAY_TEAM_WIN)) {
            updateTeamPoints(awayTeam, awayTeamPoints + pointsForAWin);
            return;
        }
        if (matchOutcome.equals(TIE)) {
            updateTeamPoints(homeTeam, homeTeamPoints + pointsForATie);
            updateTeamPoints(awayTeam, awayTeamPoints + pointsForATie);
        }
    }

    public void updateTeamPoints(Team team, int pointsToAdd) {
        repository.updateTeamPoints(pointsToAdd, team.getId());
    }

    public List<Team> getGroupDataOrderedByPoints() {
        return groupRepository.getAllGroups()
                .stream()
                .map(group -> repository.getTeamsByTournamentGroupId(group.getId(), Sort.by("points").descending()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
