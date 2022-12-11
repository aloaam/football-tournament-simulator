package com.example.footballtournamentsimulator.match;

import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;

import static com.example.footballtournamentsimulator.team.TeamName.*;

public class MatchResultsGenerator {


    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public MatchResultsGenerator(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public void generateMatchResults() {
        generateMatchResultsGroupC();
    }

    public void generateMatchResultsGroupC() {
        Team arg = teamRepository.getTeamByTeamName(ARGENTINA);
        Team mex = teamRepository.getTeamByTeamName(MEXICO);
        Team pol = teamRepository.getTeamByTeamName(POLAND);
        Team sau = teamRepository.getTeamByTeamName(SAUDI_ARABIA);

        matchRepository.updatePoints(arg.getId(), sau.getId(), 1, 2);
        matchRepository.updatePoints(mex.getId(), pol.getId(), 0, 0);
        matchRepository.updatePoints(arg.getId(), mex.getId(), 2, 0);
        matchRepository.updatePoints(sau.getId(), pol.getId(), 0, 2);
        matchRepository.updatePoints(arg.getId(), pol.getId(), 2, 0);
        matchRepository.updatePoints(mex.getId(), sau.getId(), 2, 1);

    }
}
