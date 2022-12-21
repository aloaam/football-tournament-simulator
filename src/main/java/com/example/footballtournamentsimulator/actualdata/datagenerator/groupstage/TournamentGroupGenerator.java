package com.example.footballtournamentsimulator.actualdata.datagenerator.groupstage;

import com.example.footballtournamentsimulator.actualdata.datagenerator.DataGenerator;
import com.example.footballtournamentsimulator.actualdata.team.Team;
import com.example.footballtournamentsimulator.actualdata.team.TeamRepository;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroup;

import java.util.List;

import static com.example.footballtournamentsimulator.actualdata.team.TeamName.*;
import static com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupName.*;

/**
 * Generates the groups (used if the application is generated from scratch).
 */
public class TournamentGroupGenerator implements DataGenerator {

    private final TeamRepository teamRepository;

    public TournamentGroupGenerator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void generate() {
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
                new Team(AJAX, group),
                new Team(LIVERPOOL, group),
                new Team(NAPOLI, group),
                new Team(RANGERS, group)
        ));
    }

    private void generateTournamentGroupB() {
        final TournamentGroup group = new TournamentGroup(B);
        saveGroupInDb(List.of(
                new Team(ATLETICO_MADRID, group),
                new Team(LEVERKUSEN, group),
                new Team(CLUB_BRUGGE, group),
                new Team(PORTO, group)
        ));
    }

    private void generateTournamentGroupC() {
        final TournamentGroup group = new TournamentGroup(C);
        saveGroupInDb(List.of(
                new Team(BAYERN_MUNICH, group),
                new Team(INTER_MILAN, group),
                new Team(FC_BARCELONA, group),
                new Team(VIKTORIA_PLZEN, group)
        ));
    }

    private void generateTournamentGroupD() {
        final TournamentGroup group = new TournamentGroup(D);
        saveGroupInDb(List.of(
                new Team(EINTRACHT_FRANKFURT, group),
                new Team(MARSEILLE, group),
                new Team(SPORTING_CP, group),
                new Team(TOTTENHAM, group)
        ));
    }

    private void generateTournamentGroupE() {
        final TournamentGroup group = new TournamentGroup(E);
        saveGroupInDb(List.of(
                new Team(AC_MILAN, group),
                new Team(CHELSEA, group),
                new Team(DINAMO_ZAGREB, group),
                new Team(SALZBURG, group)
        ));

    }

    private void generateTournamentGroupF() {
        final TournamentGroup group = new TournamentGroup(F);
        saveGroupInDb(List.of(
                new Team(CELTIC, group),
                new Team(RB_LEIPZIG, group),
                new Team(REAL_MADRID, group),
                new Team(SHAKHTAR_DONETSK, group)
        ));
    }

    private void generateTournamentGroupG() {
        final TournamentGroup group = new TournamentGroup(G);
        saveGroupInDb(List.of(
                new Team(COPENHAGEN, group),
                new Team(DORTMUND, group),
                new Team(MANCHESTER_CITY, group),
                new Team(SEVILLA, group)
        ));
    }

    private void generateTournamentGroupH() {
        final TournamentGroup group = new TournamentGroup(H);
        saveGroupInDb(List.of(
                new Team(BENFICA, group),
                new Team(JUVENTUS, group),
                new Team(MACCABI_HAIFA, group),
                new Team(PARIS_SAINT_GERMAIN, group)
        ));
    }

    //TODO: Alo - add save all to the repo.
    private void saveGroupInDb(List<Team> teams) {
        teamRepository.saveAll(teams);
    }
}
