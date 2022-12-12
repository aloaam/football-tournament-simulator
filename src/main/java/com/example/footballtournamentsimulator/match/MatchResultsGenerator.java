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
        generateMatchResultsGroupA();
        generateMatchResultsGroupC();
    }

    public void generateMatchResultsGroupA() {
        Team ecu = teamRepository.getTeamByTeamName(ECUADOR);
        Team nld = teamRepository.getTeamByTeamName(NETHERLANDS);
        Team qat = teamRepository.getTeamByTeamName(QATAR);
        Team sen = teamRepository.getTeamByTeamName(SENEGAL);

        matchRepository.updatePoints(qat.getId(), ecu.getId(), 0, 2);
        matchRepository.updatePoints(sen.getId(), nld.getId(), 0, 2);
        matchRepository.updatePoints(qat.getId(), sen.getId(), 1, 3);
        matchRepository.updatePoints(nld.getId(), ecu.getId(), 1, 1);
        matchRepository.updatePoints(ecu.getId(), sen.getId(), 1, 2);
        matchRepository.updatePoints(nld.getId(), qat.getId(), 2, 0);

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
