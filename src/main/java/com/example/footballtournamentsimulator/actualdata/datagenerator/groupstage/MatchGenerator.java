package com.example.footballtournamentsimulator.actualdata.datagenerator.groupstage;

import com.example.footballtournamentsimulator.actualdata.datagenerator.DataGenerator;
import com.example.footballtournamentsimulator.actualdata.match.Match;
import com.example.footballtournamentsimulator.actualdata.match.MatchRepository;
import com.example.footballtournamentsimulator.actualdata.team.Team;
import com.example.footballtournamentsimulator.actualdata.team.TeamRepository;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroup;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupRepository;

import java.util.List;

import static com.example.footballtournamentsimulator.actualdata.team.TeamName.*;
import static com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupName.*;

/**
 * Fills in the 'match' table, with the matches that will take place,
 * it doesn't include the score or the data which is calculated with it.
 */
@SuppressWarnings("DuplicatedCode")
public class MatchGenerator implements DataGenerator {
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

        Team ajx = teamRepository.getTeamByTeamName(AJAX);
        Team lvp = teamRepository.getTeamByTeamName(LIVERPOOL);
        Team npl = teamRepository.getTeamByTeamName(NAPOLI);
        Team rng = teamRepository.getTeamByTeamName(RANGERS);

        storeMatches(
                List.of(
                        new Match(ajx, rng, group, 1),
                        new Match(npl, lvp, group, 1),
                        new Match(lvp, ajx, group, 2),
                        new Match(rng, npl, group, 2),
                        new Match(ajx, npl, group, 3),
                        new Match(lvp, rng, group, 3),
                        new Match(npl, ajx, group, 4),
                        new Match(rng, lvp, group, 4),
                        new Match(ajx, lvp, group, 5),
                        new Match(npl, rng, group, 5),
                        new Match(rng, ajx, group, 6),
                        new Match(lvp, npl, group, 6)
                )
        );
    }

    private void generateMatchesGroupB() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(B);

        Team atm = teamRepository.getTeamByTeamName(ATLETICO_MADRID);
        Team lev = teamRepository.getTeamByTeamName(LEVERKUSEN);
        Team bru = teamRepository.getTeamByTeamName(CLUB_BRUGGE);
        Team por = teamRepository.getTeamByTeamName(PORTO);

        storeMatches(
                List.of(
                        new Match(bru, lev, group, 1),
                        new Match(atm, por, group, 1),
                        new Match(lev, atm, group, 2),
                        new Match(por, bru, group, 2),
                        new Match(bru, atm, group, 3),
                        new Match(por, lev, group, 3),
                        new Match(atm, bru, group, 4),
                        new Match(lev, por, group, 4),
                        new Match(bru, por, group, 5),
                        new Match(atm, lev, group, 5),
                        new Match(lev, bru, group, 6),
                        new Match(por, atm, group, 6)
                )
        );
    }

    private void generateMatchesGroupC() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(C);

        Team mun = teamRepository.getTeamByTeamName(BAYERN_MUNICH);
        Team iml = teamRepository.getTeamByTeamName(INTER_MILAN);
        Team bar = teamRepository.getTeamByTeamName(FC_BARCELONA);
        Team plz = teamRepository.getTeamByTeamName(VIKTORIA_PLZEN);

        storeMatches(
                List.of(
                        new Match(iml, mun, group, 1),
                        new Match(bar, plz, group, 1),
                        new Match(plz, iml, group, 2),
                        new Match(mun, bar, group, 2),
                        new Match(mun, plz, group, 3),
                        new Match(iml, bar, group, 3),
                        new Match(plz, mun, group, 4),
                        new Match(bar, iml, group, 4),
                        new Match(iml, plz, group, 5),
                        new Match(bar, mun, group, 5),
                        new Match(plz, bar, group, 6),
                        new Match(mun, iml, group, 6)
                )
        );
    }

    private void generateMatchesGroupD() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(D);

        Team fra = teamRepository.getTeamByTeamName(EINTRACHT_FRANKFURT);
        Team mar = teamRepository.getTeamByTeamName(MARSEILLE);
        Team spo = teamRepository.getTeamByTeamName(SPORTING_CP);
        Team tot = teamRepository.getTeamByTeamName(TOTTENHAM);

        storeMatches(
                List.of(
                        new Match(fra, spo, group, 1),
                        new Match(tot, mar, group, 1),
                        new Match(spo, tot, group, 2),
                        new Match(mar, fra, group, 2),
                        new Match(mar, spo, group, 3),
                        new Match(fra, tot, group, 3),
                        new Match(spo, mar, group, 4),
                        new Match(tot, fra, group, 4),
                        new Match(fra, mar, group, 5),
                        new Match(tot, spo, group, 5),
                        new Match(mar, tot, group, 6),
                        new Match(spo, fra, group, 6)
                )
        );
    }

    private void generateMatchesGroupE() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(E);

        Team acm = teamRepository.getTeamByTeamName(AC_MILAN);
        Team che = teamRepository.getTeamByTeamName(CHELSEA);
        Team din = teamRepository.getTeamByTeamName(DINAMO_ZAGREB);
        Team sal = teamRepository.getTeamByTeamName(SALZBURG);

        storeMatches(
                List.of(
                        new Match(din, che, group, 1),
                        new Match(sal, acm, group, 1),
                        new Match(acm, din, group, 2),
                        new Match(che, sal, group, 2),
                        new Match(sal, din, group, 3),
                        new Match(che, acm, group, 3),
                        new Match(acm, che, group, 4),
                        new Match(din, sal, group, 4),
                        new Match(sal, che, group, 5),
                        new Match(din, acm, group, 5),
                        new Match(acm, sal, group, 6),
                        new Match(che, din, group, 6)
                )
        );
    }

    private void generateMatchesGroupF() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(F);

        Team cel = teamRepository.getTeamByTeamName(CELTIC);
        Team lei = teamRepository.getTeamByTeamName(RB_LEIPZIG);
        Team mad = teamRepository.getTeamByTeamName(REAL_MADRID);
        Team sha = teamRepository.getTeamByTeamName(SHAKHTAR_DONETSK);

        storeMatches(
                List.of(
                        new Match(lei, sha, group, 1),
                        new Match(cel, mad, group, 1),
                        new Match(sha, cel, group, 2),
                        new Match(mad, lei, group, 2),
                        new Match(lei, cel, group, 3),
                        new Match(mad, sha, group, 3),
                        new Match(cel, lei, group, 4),
                        new Match(sha, mad, group, 4),
                        new Match(lei, mad, group, 5),
                        new Match(cel, sha, group, 5),
                        new Match(sha, lei, group, 6),
                        new Match(mad, cel, group, 6)
                )
        );
    }

    private void generateMatchesGroupG() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(G);

        Team cop = teamRepository.getTeamByTeamName(COPENHAGEN);
        Team dor = teamRepository.getTeamByTeamName(DORTMUND);
        Team cit = teamRepository.getTeamByTeamName(MANCHESTER_CITY);
        Team sev = teamRepository.getTeamByTeamName(SEVILLA);

        storeMatches(
                List.of(
                        new Match(dor, cop, group, 1),
                        new Match(cit, sev, group, 1),
                        new Match(cop, sev, group, 2),
                        new Match(cit, dor, group, 2),
                        new Match(sev, dor, group, 3),
                        new Match(cit, cop, group, 3),
                        new Match(cop, cit, group, 4),
                        new Match(dor, sev, group, 4),
                        new Match(sev, cop, group, 5),
                        new Match(dor, cit, group, 5),
                        new Match(cop, dor, group, 6),
                        new Match(cit, sev, group, 6)
                )
        );
    }

    private void generateMatchesGroupH() {

        TournamentGroup group = tournamentGroupRepository.getTournamentGroupByName(H);

        Team ben = teamRepository.getTeamByTeamName(BENFICA);
        Team juv = teamRepository.getTeamByTeamName(JUVENTUS);
        Team hai = teamRepository.getTeamByTeamName(MACCABI_HAIFA);
        Team psg = teamRepository.getTeamByTeamName(PARIS_SAINT_GERMAIN);

        storeMatches(
                List.of(
                        new Match(ben, hai, group, 1),
                        new Match(psg, juv, group, 1),
                        new Match(hai, psg, group, 2),
                        new Match(juv, ben, group, 2),
                        new Match(ben, psg, group, 3),
                        new Match(juv, hai, group, 3),
                        new Match(hai, juv, group, 4),
                        new Match(psg, ben, group, 4),
                        new Match(ben, juv, group, 5),
                        new Match(psg, hai, group, 5),
                        new Match(hai, ben, group, 6),
                        new Match(juv, psg, group, 6)
                )
        );
    }

    //TODO: Alo - add save all to the repo.
    private void storeMatches(List<Match> matches) {
        matchRepository.saveAll(matches);
    }
}
