package com.example.footballtournamentsimulator.datagenerator;

import com.example.footballtournamentsimulator.match.Match;
import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroup;
import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupRepository;

import java.util.List;

import static com.example.footballtournamentsimulator.team.TeamName.*;
import static com.example.footballtournamentsimulator.tournamentgroup.TournamentGroupName.*;

/**
 * Fills in the 'match' table, with the matches that will take place,
 * it doesn't include the score or the data which is calculated with it.
 */
@SuppressWarnings("DuplicatedCode")
public class MatchGenerator implements DataGenerator {
//TODO: ALO - change names in the acronyms, or better do inline variables, remove barcelona
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final TournamentGroupRepository tournamentGroupRepository;

    public MatchGenerator(MatchRepository matchRepository, TeamRepository teamRepository, TournamentGroupRepository tournamentGroupRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.tournamentGroupRepository = tournamentGroupRepository;
    }

    @Override
    public void generate() {
        generateMatchesGroupA();
        generateMatchesGroupB();
        generateMatchesGroupC();
        generateMatchesGroupG();
        generateMatchesGroupD();
        generateMatchesGroupE();
        generateMatchesGroupF();
        generateMatchesGroupH();
    }

    private void generateMatchesGroupA() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(A);

        Team ecu = teamRepository.getTeamByTeamName(NAPOLI);
        Team nld = teamRepository.getTeamByTeamName(LIVERPOOL);
        Team qat = teamRepository.getTeamByTeamName(AJAX);
        Team sen = teamRepository.getTeamByTeamName(RANGERS);

        storeMatches(
                List.of(
                        new Match(qat, ecu, group, 1),
                        new Match(sen, nld, group, 1),
                        new Match(qat, sen, group, 2),
                        new Match(nld, ecu, group, 2),
                        new Match(ecu, sen, group, 3),
                        new Match(nld, qat, group, 3),
                        new Match(nld, qat, group, 4),
                        new Match(nld, qat, group, 4),
                        new Match(nld, qat, group, 5),
                        new Match(nld, qat, group, 5),
                        new Match(nld, qat, group, 6),
                        new Match(nld, qat, group, 6)
                )
        );
    }

    private void generateMatchesGroupB() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team eng = teamRepository.getTeamByTeamName(PORTO);
        Team irn = teamRepository.getTeamByTeamName(CLUB_BRUGGE);
        Team usa = teamRepository.getTeamByTeamName(BAYERN_LEVERKUSEN);
        Team wls = teamRepository.getTeamByTeamName(ATLETICO_MADRID);

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

        Team arg = teamRepository.getTeamByTeamName(BAYERN_MUNICH);
        Team mex = teamRepository.getTeamByTeamName(INTER_MILAN);
        Team pol = teamRepository.getTeamByTeamName(FC_BARCELONA);
        Team sau = teamRepository.getTeamByTeamName();

        storeMatches(
                List.of(
                        new Match(arg, sau, group, 1),
                        new Match(mex, pol, group, 1),
                        new Match(pol, sau, group, 2),
                        new Match(arg, mex, group, 2),
                        new Match(pol, arg, group, 3),
                        new Match(sau, mex, group, 3)
                )
        );
    }

    private void generateMatchesGroupD() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team aus = teamRepository.getTeamByTeamName();
        Team dnk = teamRepository.getTeamByTeamName();
        Team fra = teamRepository.getTeamByTeamName();
        Team tun = teamRepository.getTeamByTeamName();

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

        Team cri = teamRepository.getTeamByTeamName();
        Team deu = teamRepository.getTeamByTeamName();
        Team jpn = teamRepository.getTeamByTeamName();
        Team esp = teamRepository.getTeamByTeamName();

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

        Team bel = teamRepository.getTeamByTeamName();
        Team can = teamRepository.getTeamByTeamName();
        Team hrv = teamRepository.getTeamByTeamName();
        Team mar = teamRepository.getTeamByTeamName();

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

        Team bra = teamRepository.getTeamByTeamName();
        Team cmr = teamRepository.getTeamByTeamName();
        Team srb = teamRepository.getTeamByTeamName();
        Team che = teamRepository.getTeamByTeamName();

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

        Team gha = teamRepository.getTeamByTeamName();
        Team prt = teamRepository.getTeamByTeamName();
        Team kor = teamRepository.getTeamByTeamName();
        Team ury = teamRepository.getTeamByTeamName();

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
