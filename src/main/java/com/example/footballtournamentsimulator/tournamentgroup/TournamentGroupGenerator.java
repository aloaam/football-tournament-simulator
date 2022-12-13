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
        saveGroupInDb(List.of(
                new Team(ENGLAND, group),
                new Team(IRAN, group),
                new Team(USA, group),
                new Team(WALES, group)
        ));
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
        saveGroupInDb(List.of(
                new Team(AUSTRALIA, group),
                new Team(DENMARK, group),
                new Team(FRANCE, group),
                new Team(TUNISIA, group)
        ));
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
        saveGroupInDb(List.of(
                new Team(BELGIUM, group),
                new Team(CANADA, group),
                new Team(CROATIA, group),
                new Team(MOROCCO, group)
        ));
    }

    private void generateTournamentGroupG() {
        final TournamentGroup group = new TournamentGroup(G);
        saveGroupInDb(List.of(
                new Team(BRAZIL, group),
                new Team(CAMEROON, group),
                new Team(SERBIA, group),
                new Team(SWITZERLAND, group)
        ));
    }

    private void generateTournamentGroupH() {
        final TournamentGroup group = new TournamentGroup(H);
        saveGroupInDb(List.of(
                new Team(GHANA, group),
                new Team(PORTUGAL, group),
                new Team(SOUTH_KOREA, group),
                new Team(URUGUAY, group)
        ));
    }

    private void saveGroupInDb(List<Team> teams) {
        teamRepository.saveAll(teams);
    }

}
