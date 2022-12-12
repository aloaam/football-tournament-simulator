package com.example.footballtournamentsimulator.tournamentgroup;

import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;

import java.util.List;

import static com.example.footballtournamentsimulator.team.TeamName.*;
import static com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName.*;

/**
 * Generates the groups (used if the application is generated from scratch).
 */
public class TournamentGroupGenerator {

    private final TeamRepository teamRepository;

    public TournamentGroupGenerator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void generateTournamentGroups() {
        generateTournamentGroupA();
        generateTournamentGroupB();
        generateTournamentGroupC();
        generateTournamentGroupD();
        generateTournamentGroupE();
        generateTournamentGroupF();
        generateTournamentGroupG();
        generateTournamentGroupH();

    }

    private void generateTournamentGroupA() {
        final TournamentGroup group = new TournamentGroup(A);
        saveGroupInDb(List.of(
                new Team(ECUADOR,group),
                new Team(NETHERLANDS,group),
                new Team(QATAR,group),
                new Team(SENEGAL,group)
        ));
    }

    private void generateTournamentGroupB() {
        final TournamentGroup group = new TournamentGroup(B);
    }

    private void generateTournamentGroupC() {
        final TournamentGroup group = new TournamentGroup(C);
        saveGroupInDb(List.of(
                new Team(ARGENTINA, group),
                new Team(MEXICO, group),
                new Team(POLAND, group),
                new Team(SAUDI_ARABIA, group)
        ));
    }

    private void generateTournamentGroupD() {
        final TournamentGroup group = new TournamentGroup(D);
    }

    private void generateTournamentGroupE() {
        final TournamentGroup group = new TournamentGroup(E);
        saveGroupInDb(List.of(
                new Team(COSTA_RICA, group),
                new Team(GERMANY, group),
                new Team(JAPAN, group),
                new Team(SPAIN, group)
        ));

    }

    private void generateTournamentGroupF() {
        final TournamentGroup group = new TournamentGroup(F);
    }

    private void generateTournamentGroupG() {
        final TournamentGroup group = new TournamentGroup(G);
    }

    private void generateTournamentGroupH() {
        final TournamentGroup group = new TournamentGroup(H);
    }

    private void saveGroupInDb(List<Team> teams) {
        teamRepository.saveAll(teams);
    }

}
