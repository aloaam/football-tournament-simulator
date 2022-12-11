package com.example.footballtournamentsimulator.match;

import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroup;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;

import java.util.List;

import static com.example.footballtournamentsimulator.team.TeamName.*;
import static com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName.C;

public class MatchGenerator {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final TournamentGroupRepository tournamentGroupRepository;

    public MatchGenerator(MatchRepository matchRepository, TeamRepository teamRepository, TournamentGroupRepository tournamentGroupRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.tournamentGroupRepository = tournamentGroupRepository;
    }

    public void generateMatches() {
        generateMatchesGroupC();
    }

    private void generateMatchesGroupC() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(C);

        Team arg = teamRepository.getTeamByTeamName(ARGENTINA);
        Team mex = teamRepository.getTeamByTeamName(MEXICO);
        Team pol = teamRepository.getTeamByTeamName(POLAND);
        Team sau = teamRepository.getTeamByTeamName(SAUDI_ARABIA);

        storeMatches(
                List.of(
                        new Match(arg, sau, group, 1),
                        new Match(mex, pol, group, 1),
                        new Match(arg, mex, group, 2),
                        new Match(sau, pol, group, 2),
                        new Match(arg, pol, group, 3),
                        new Match(mex, sau, group, 3)
                )
        );
    }

    private void storeMatches(List<Match> matches) {
        matchRepository.saveAll(matches);
    }
}
