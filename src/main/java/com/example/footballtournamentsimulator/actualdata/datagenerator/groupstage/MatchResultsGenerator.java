package com.example.footballtournamentsimulator.actualdata.datagenerator.groupstage;

import com.example.footballtournamentsimulator.actualdata.datagenerator.DataGenerator;
import com.example.footballtournamentsimulator.actualdata.match.MatchRepository;
import com.example.footballtournamentsimulator.actualdata.team.Team;
import com.example.footballtournamentsimulator.actualdata.team.TeamRepository;

import static com.example.footballtournamentsimulator.actualdata.team.TeamName.*;


public class MatchResultsGenerator implements DataGenerator {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public MatchResultsGenerator(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public void generate() {
        generateMatchResultsGroupA();
        generateMatchResultsGroupB();
        generateMatchResultsGroupC();
        generateMatchResultsGroupD();
        generateMatchResultsGroupE();
        generateMatchResultsGroupF();
        generateMatchResultsGroupG();
        generateMatchResultsGroupH();
    }

    public void generateMatchResultsGroupA() {
        Team ajx = teamRepository.getTeamByTeamName(AJAX);
        Team lvp = teamRepository.getTeamByTeamName(LIVERPOOL);
        Team npl = teamRepository.getTeamByTeamName(NAPOLI);
        Team rng = teamRepository.getTeamByTeamName(RANGERS);


        matchRepository.updatePoints(ajx.getId(), rng.getId(), 4, 0);
        matchRepository.updatePoints(npl.getId(), lvp.getId(), 4, 1);
        matchRepository.updatePoints(lvp.getId(), ajx.getId(), 2, 1);
        matchRepository.updatePoints(rng.getId(), npl.getId(), 0, 3);
        matchRepository.updatePoints(ajx.getId(), npl.getId(), 1, 6);
        matchRepository.updatePoints(lvp.getId(), rng.getId(), 2, 0);
        matchRepository.updatePoints(npl.getId(), ajx.getId(), 4, 2);
        matchRepository.updatePoints(rng.getId(), lvp.getId(), 1, 7);
        matchRepository.updatePoints(ajx.getId(), lvp.getId(), 0, 3);
        matchRepository.updatePoints(npl.getId(), rng.getId(), 3, 0);
        matchRepository.updatePoints(rng.getId(), ajx.getId(), 1, 3);
        matchRepository.updatePoints(lvp.getId(), npl.getId(), 2, 0);

    }

    public void generateMatchResultsGroupB() {
        Team atm = teamRepository.getTeamByTeamName(ATLETICO_MADRID);
        Team lev = teamRepository.getTeamByTeamName(LEVERKUSEN);
        Team bru = teamRepository.getTeamByTeamName(CLUB_BRUGGE);
        Team por = teamRepository.getTeamByTeamName(PORTO);

        matchRepository.updatePoints(bru.getId(), lev.getId(), 1, 0);
        matchRepository.updatePoints(atm.getId(), por.getId(), 2, 1);
        matchRepository.updatePoints(lev.getId(), atm.getId(), 2, 0);
        matchRepository.updatePoints(por.getId(), bru.getId(), 0, 4);
        matchRepository.updatePoints(bru.getId(), atm.getId(), 2, 0);
        matchRepository.updatePoints(por.getId(), lev.getId(), 2, 0);
        matchRepository.updatePoints(atm.getId(), bru.getId(), 0, 0);
        matchRepository.updatePoints(lev.getId(), por.getId(), 0, 3);
        matchRepository.updatePoints(bru.getId(), por.getId(), 0, 4);
        matchRepository.updatePoints(atm.getId(), lev.getId(), 2, 2);
        matchRepository.updatePoints(lev.getId(), bru.getId(), 0, 0);
        matchRepository.updatePoints(por.getId(), atm.getId(), 2, 1);

    }

    public void generateMatchResultsGroupC() {
        Team mun = teamRepository.getTeamByTeamName(BAYERN_MUNICH);
        Team iml = teamRepository.getTeamByTeamName(INTER_MILAN);
        Team bar = teamRepository.getTeamByTeamName(FC_BARCELONA);
        Team plz = teamRepository.getTeamByTeamName(VIKTORIA_PLZEN);

        matchRepository.updatePoints(iml.getId(), mun.getId(), 0, 2);
        matchRepository.updatePoints(bar.getId(), plz.getId(), 5, 1);
        matchRepository.updatePoints(plz.getId(), iml.getId(), 0, 2);
        matchRepository.updatePoints(mun.getId(), bar.getId(), 2, 0);
        matchRepository.updatePoints(mun.getId(), plz.getId(), 5, 0);
        matchRepository.updatePoints(iml.getId(), bar.getId(), 1, 0);
        matchRepository.updatePoints(plz.getId(), mun.getId(), 2, 4);
        matchRepository.updatePoints(bar.getId(), iml.getId(), 3, 3);
        matchRepository.updatePoints(iml.getId(), plz.getId(), 4, 0);
        matchRepository.updatePoints(bar.getId(), mun.getId(), 0, 3);
        matchRepository.updatePoints(plz.getId(), bar.getId(), 2, 4);
        matchRepository.updatePoints(mun.getId(), iml.getId(), 2, 0);

    }

    public void generateMatchResultsGroupD() {
        Team fra = teamRepository.getTeamByTeamName(EINTRACHT_FRANKFURT);
        Team mar = teamRepository.getTeamByTeamName(MARSEILLE);
        Team spo = teamRepository.getTeamByTeamName(SPORTING_CP);
        Team tot = teamRepository.getTeamByTeamName(TOTTENHAM);

        matchRepository.updatePoints(fra.getId(), spo.getId(), 0, 3);
        matchRepository.updatePoints(tot.getId(), mar.getId(), 2, 0);
        matchRepository.updatePoints(spo.getId(), tot.getId(), 2, 0);
        matchRepository.updatePoints(mar.getId(), fra.getId(), 0, 1);
        matchRepository.updatePoints(mar.getId(), spo.getId(), 4, 1);
        matchRepository.updatePoints(fra.getId(), tot.getId(), 0, 0);
        matchRepository.updatePoints(spo.getId(), mar.getId(), 0, 2);
        matchRepository.updatePoints(tot.getId(), fra.getId(), 3, 2);
        matchRepository.updatePoints(fra.getId(), mar.getId(), 2, 1);
        matchRepository.updatePoints(tot.getId(), spo.getId(), 1, 1);
        matchRepository.updatePoints(mar.getId(), tot.getId(), 1, 2);
        matchRepository.updatePoints(spo.getId(), fra.getId(), 1, 2);

    }

    public void generateMatchResultsGroupE() {
        Team acm = teamRepository.getTeamByTeamName(AC_MILAN);
        Team che = teamRepository.getTeamByTeamName(CHELSEA);
        Team din = teamRepository.getTeamByTeamName(DINAMO_ZAGREB);
        Team sal = teamRepository.getTeamByTeamName(SALZBURG);

        matchRepository.updatePoints(din.getId(), che.getId(), 1, 0);
        matchRepository.updatePoints(sal.getId(), acm.getId(), 1, 1);
        matchRepository.updatePoints(acm.getId(), din.getId(), 3, 1);
        matchRepository.updatePoints(che.getId(), sal.getId(), 1, 1);
        matchRepository.updatePoints(sal.getId(), din.getId(), 1, 0);
        matchRepository.updatePoints(che.getId(), acm.getId(), 3, 0);
        matchRepository.updatePoints(acm.getId(), che.getId(), 0, 2);
        matchRepository.updatePoints(din.getId(), sal.getId(), 1, 1);
        matchRepository.updatePoints(sal.getId(), che.getId(), 1, 2);
        matchRepository.updatePoints(din.getId(), acm.getId(), 0, 4);
        matchRepository.updatePoints(acm.getId(), sal.getId(), 4, 0);
        matchRepository.updatePoints(che.getId(), din.getId(), 2, 1);

    }

    public void generateMatchResultsGroupF() {
        Team cel = teamRepository.getTeamByTeamName(CELTIC);
        Team lei = teamRepository.getTeamByTeamName(RB_LEIPZIG);
        Team mad = teamRepository.getTeamByTeamName(REAL_MADRID);
        Team sha = teamRepository.getTeamByTeamName(SHAKHTAR_DONETSK);

        matchRepository.updatePoints(lei.getId(), sha.getId(), 1, 4);
        matchRepository.updatePoints(cel.getId(), mad.getId(), 0, 3);
        matchRepository.updatePoints(sha.getId(), cel.getId(), 1, 1);
        matchRepository.updatePoints(mad.getId(), lei.getId(), 2, 0);
        matchRepository.updatePoints(lei.getId(), cel.getId(), 3, 1);
        matchRepository.updatePoints(mad.getId(), sha.getId(), 2, 1);
        matchRepository.updatePoints(cel.getId(), lei.getId(), 0, 2);
        matchRepository.updatePoints(sha.getId(), mad.getId(), 1, 1);
        matchRepository.updatePoints(lei.getId(), mad.getId(), 3, 2);
        matchRepository.updatePoints(cel.getId(), sha.getId(), 1, 1);
        matchRepository.updatePoints(sha.getId(), lei.getId(), 0, 4);
        matchRepository.updatePoints(mad.getId(), cel.getId(), 5, 1);

    }

    public void generateMatchResultsGroupG() {
        Team cop = teamRepository.getTeamByTeamName(COPENHAGEN);
        Team dor = teamRepository.getTeamByTeamName(DORTMUND);
        Team cit = teamRepository.getTeamByTeamName(MANCHESTER_CITY);
        Team sev = teamRepository.getTeamByTeamName(SEVILLA);

        matchRepository.updatePoints(dor.getId(), cop.getId(), 3, 0);
        matchRepository.updatePoints(sev.getId(), cit.getId(), 0, 4);
        matchRepository.updatePoints(cop.getId(), sev.getId(), 0, 0);
        matchRepository.updatePoints(cit.getId(), dor.getId(), 2, 1);
        matchRepository.updatePoints(sev.getId(), dor.getId(), 1, 4);
        matchRepository.updatePoints(cit.getId(), cop.getId(), 5, 0);
        matchRepository.updatePoints(cop.getId(), cit.getId(), 0, 0);
        matchRepository.updatePoints(dor.getId(), sev.getId(), 1, 1);
        matchRepository.updatePoints(sev.getId(), cop.getId(), 3, 0);
        matchRepository.updatePoints(dor.getId(), cit.getId(), 0, 0);
        matchRepository.updatePoints(cop.getId(), dor.getId(), 1, 1);
        matchRepository.updatePoints(cit.getId(), sev.getId(), 3, 1);

    }

    public void generateMatchResultsGroupH() {
        Team ben = teamRepository.getTeamByTeamName(BENFICA);
        Team juv = teamRepository.getTeamByTeamName(JUVENTUS);
        Team hai = teamRepository.getTeamByTeamName(MACCABI_HAIFA);
        Team psg = teamRepository.getTeamByTeamName(PARIS_SAINT_GERMAIN);

        matchRepository.updatePoints(ben.getId(), hai.getId(), 2, 0);
        matchRepository.updatePoints(psg.getId(), juv.getId(), 2, 1);
        matchRepository.updatePoints(hai.getId(), psg.getId(), 1, 3);
        matchRepository.updatePoints(juv.getId(), ben.getId(), 1, 2);
        matchRepository.updatePoints(ben.getId(), psg.getId(), 1, 1);
        matchRepository.updatePoints(juv.getId(), hai.getId(), 3, 1);
        matchRepository.updatePoints(hai.getId(), juv.getId(), 2, 0);
        matchRepository.updatePoints(psg.getId(), ben.getId(), 1, 1);
        matchRepository.updatePoints(ben.getId(), juv.getId(), 4, 3);
        matchRepository.updatePoints(psg.getId(), hai.getId(), 7, 2);
        matchRepository.updatePoints(hai.getId(), ben.getId(), 1, 6);
        matchRepository.updatePoints(juv.getId(), psg.getId(), 1, 2);

    }
}
