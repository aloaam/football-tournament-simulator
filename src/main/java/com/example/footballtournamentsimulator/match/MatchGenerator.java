package com.example.footballtournamentsimulator.match;

import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroup;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;

import java.util.List;

import static com.example.footballtournamentsimulator.team.TeamName.*;
import static com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName.*;

@SuppressWarnings("DuplicatedCode")
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
        generateMatchesGroupA();
        generateMatchesGroupB();
        generateMatchesGroupC();
        generateMatchesGroupD();
        generateMatchesGroupE();
        generateMatchesGroupF();
        generateMatchesGroupG();
        generateMatchesGroupH();
    }

    private void generateMatchesGroupA() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(A);

        Team ecu = teamRepository.getTeamByTeamName(ECUADOR);
        Team nld = teamRepository.getTeamByTeamName(NETHERLANDS);
        Team qat = teamRepository.getTeamByTeamName(QATAR);
        Team sen = teamRepository.getTeamByTeamName(SENEGAL);

        storeMatches(
                List.of(
                        new Match(qat, ecu, group, 1),
                        new Match(sen, nld, group, 1),
                        new Match(qat, sen, group, 2),
                        new Match(nld, ecu, group, 2),
                        new Match(ecu, sen, group, 3),
                        new Match(nld, qat, group, 3)
                )
        );
    }

    private void generateMatchesGroupB() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team eng = teamRepository.getTeamByTeamName(ENGLAND);
        Team irn = teamRepository.getTeamByTeamName(IRAN);
        Team usa = teamRepository.getTeamByTeamName(USA);
        Team wls = teamRepository.getTeamByTeamName(WALES);

        storeMatches(
                List.of(
                        new Match(eng, irn, group, 1),
                        new Match(usa, wls, group, 1),
                        new Match(wls, irn, group, 2),
                        new Match(eng, usa, group, 2),
                        new Match(irn, usa, group, 3),
                        new Match(wls, eng, group, 3)
                )
        );
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

    private void generateMatchesGroupD() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team aus = teamRepository.getTeamByTeamName(AUSTRALIA);
        Team dnk = teamRepository.getTeamByTeamName(DENMARK);
        Team fra = teamRepository.getTeamByTeamName(FRANCE);
        Team tun = teamRepository.getTeamByTeamName(TUNISIA);

        storeMatches(
                List.of(
                        new Match(dnk, tun, group, 1),
                        new Match(fra, aus, group, 1),
                        new Match(tun, aus, group, 2),
                        new Match(fra, dnk, group, 2),
                        new Match(tun, fra, group, 3),
                        new Match(aus, dnk, group, 3)
                )
        );
    }

    private void generateMatchesGroupE() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team cri = teamRepository.getTeamByTeamName(COSTA_RICA);
        Team deu = teamRepository.getTeamByTeamName(GERMANY);
        Team jpn = teamRepository.getTeamByTeamName(JAPAN);
        Team esp = teamRepository.getTeamByTeamName(SPAIN);

        storeMatches(
                List.of(
                        new Match(deu, jpn, group, 1),
                        new Match(esp, cri, group, 1),
                        new Match(jpn, cri, group, 2),
                        new Match(esp, deu, group, 2),
                        new Match(jpn, esp, group, 3),
                        new Match(cri, deu, group, 3)
                )
        );
    }

    private void generateMatchesGroupF() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team bel = teamRepository.getTeamByTeamName(BELGIUM);
        Team can = teamRepository.getTeamByTeamName(CANADA);
        Team hrv = teamRepository.getTeamByTeamName(CROATIA);
        Team mar = teamRepository.getTeamByTeamName(MOROCCO);

        storeMatches(
                List.of(
                        new Match(mar, hrv, group, 1),
                        new Match(bel, can, group, 1),
                        new Match(bel, mar, group, 2),
                        new Match(hrv, can, group, 2),
                        new Match(hrv, bel, group, 3),
                        new Match(can, mar, group, 3)
                )
        );
    }

    private void generateMatchesGroupG() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team bra = teamRepository.getTeamByTeamName(BRAZIL);
        Team cmr = teamRepository.getTeamByTeamName(CAMEROON);
        Team srb = teamRepository.getTeamByTeamName(SERBIA);
        Team che = teamRepository.getTeamByTeamName(SWITZERLAND);

        storeMatches(
                List.of(
                        new Match(che, cmr, group, 1),
                        new Match(bra, srb, group, 1),
                        new Match(cmr, srb, group, 2),
                        new Match(bra, che, group, 2),
                        new Match(srb, che, group, 3),
                        new Match(cmr, bra, group, 3)
                )
        );
    }

    private void generateMatchesGroupH() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team gha = teamRepository.getTeamByTeamName(GHANA);
        Team prt = teamRepository.getTeamByTeamName(PORTUGAL);
        Team kor = teamRepository.getTeamByTeamName(SOUTH_KOREA);
        Team ury = teamRepository.getTeamByTeamName(URUGUAY);

        storeMatches(
                List.of(
                        new Match(ury, kor, group, 1),
                        new Match(prt, gha, group, 1),
                        new Match(kor, gha, group, 2),
                        new Match(prt, ury, group, 2),
                        new Match(kor, prt, group, 3),
                        new Match(gha, ury, group, 3)
                )
        );
    }

    private void storeMatches(List<Match> matches) {
        matchRepository.saveAll(matches);
    }
}
