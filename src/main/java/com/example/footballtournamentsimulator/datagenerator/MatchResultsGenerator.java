package com.example.footballtournamentsimulator.datagenerator;

import com.example.footballtournamentsimulator.match.MatchRepository;
import com.example.footballtournamentsimulator.team.Team;
import com.example.footballtournamentsimulator.team.TeamRepository;

import static com.example.footballtournamentsimulator.team.TeamName.*;


//TODO: ALO - create triple key for the match table, match-day, home-team, away team
//TODO: ALO - factor out
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

    public void generateMatchResultsGroupB() {
        Team eng = teamRepository.getTeamByTeamName(ENGLAND);
        Team irn = teamRepository.getTeamByTeamName(IRAN);
        Team usa = teamRepository.getTeamByTeamName(USA);
        Team wls = teamRepository.getTeamByTeamName(WALES);

        matchRepository.updatePoints(eng.getId(), irn.getId(), 6, 2);
        matchRepository.updatePoints(usa.getId(), wls.getId(), 1, 1);
        matchRepository.updatePoints(wls.getId(), irn.getId(), 0, 2);
        matchRepository.updatePoints(eng.getId(), usa.getId(), 0, 0);
        matchRepository.updatePoints(irn.getId(), usa.getId(), 0, 1);
        matchRepository.updatePoints(wls.getId(), eng.getId(), 0, 3);

    }

    public void generateMatchResultsGroupC() {
        Team arg = teamRepository.getTeamByTeamName(ARGENTINA);
        Team mex = teamRepository.getTeamByTeamName(MEXICO);
        Team pol = teamRepository.getTeamByTeamName(POLAND);
        Team sau = teamRepository.getTeamByTeamName(SAUDI_ARABIA);

        matchRepository.updatePoints(arg.getId(), sau.getId(), 1, 2);
        matchRepository.updatePoints(mex.getId(), pol.getId(), 0, 0);
        matchRepository.updatePoints(pol.getId(), sau.getId(), 2, 0);
        matchRepository.updatePoints(arg.getId(), mex.getId(), 2, 0);
        matchRepository.updatePoints(pol.getId(), arg.getId(), 0, 2);
        matchRepository.updatePoints(sau.getId(), mex.getId(), 1, 2);

    }

    public void generateMatchResultsGroupD() {
        Team aus = teamRepository.getTeamByTeamName(AUSTRALIA);
        Team dnk = teamRepository.getTeamByTeamName(DENMARK);
        Team fra = teamRepository.getTeamByTeamName(FRANCE);
        Team tun = teamRepository.getTeamByTeamName(TUNISIA);

        matchRepository.updatePoints(dnk.getId(), tun.getId(), 0, 0);
        matchRepository.updatePoints(fra.getId(), aus.getId(), 4, 1);
        matchRepository.updatePoints(tun.getId(), aus.getId(), 0, 1);
        matchRepository.updatePoints(fra.getId(), dnk.getId(), 2, 1);
        matchRepository.updatePoints(tun.getId(), fra.getId(), 1, 0);
        matchRepository.updatePoints(aus.getId(), dnk.getId(), 1, 0);

    }

    public void generateMatchResultsGroupE() {
        Team cri = teamRepository.getTeamByTeamName(COSTA_RICA);
        Team deu = teamRepository.getTeamByTeamName(GERMANY);
        Team jpn = teamRepository.getTeamByTeamName(JAPAN);
        Team esp = teamRepository.getTeamByTeamName(SPAIN);

        matchRepository.updatePoints(deu.getId(), jpn.getId(), 1, 2);
        matchRepository.updatePoints(esp.getId(), cri.getId(), 7, 0);
        matchRepository.updatePoints(jpn.getId(), cri.getId(), 0, 1);
        matchRepository.updatePoints(esp.getId(), deu.getId(), 1, 1);
        matchRepository.updatePoints(jpn.getId(), esp.getId(), 2, 1);
        matchRepository.updatePoints(cri.getId(), deu.getId(), 2, 4);

    }

    public void generateMatchResultsGroupF() {
        Team bel = teamRepository.getTeamByTeamName(BELGIUM);
        Team can = teamRepository.getTeamByTeamName(CANADA);
        Team hrv = teamRepository.getTeamByTeamName(CROATIA);
        Team mar = teamRepository.getTeamByTeamName(MOROCCO);

        matchRepository.updatePoints(mar.getId(), hrv.getId(), 0, 0);
        matchRepository.updatePoints(bel.getId(), can.getId(), 1, 0);
        matchRepository.updatePoints(bel.getId(), mar.getId(), 0, 2);
        matchRepository.updatePoints(hrv.getId(), can.getId(), 4, 1);
        matchRepository.updatePoints(hrv.getId(), bel.getId(), 0, 0);
        matchRepository.updatePoints(can.getId(), mar.getId(), 1, 2);

    }

    public void generateMatchResultsGroupG() {
        Team bra = teamRepository.getTeamByTeamName(BRAZIL);
        Team cmr = teamRepository.getTeamByTeamName(CAMEROON);
        Team srb = teamRepository.getTeamByTeamName(SERBIA);
        Team che = teamRepository.getTeamByTeamName(SWITZERLAND);

        matchRepository.updatePoints(che.getId(), cmr.getId(), 1, 0);
        matchRepository.updatePoints(bra.getId(), srb.getId(), 2, 0);
        matchRepository.updatePoints(cmr.getId(), srb.getId(), 3, 3);
        matchRepository.updatePoints(bra.getId(), che.getId(), 1, 0);
        matchRepository.updatePoints(srb.getId(), che.getId(), 2, 3);
        matchRepository.updatePoints(cmr.getId(), bra.getId(), 1, 0);

    }

    public void generateMatchResultsGroupH() {
        Team gha = teamRepository.getTeamByTeamName(GHANA);
        Team prt = teamRepository.getTeamByTeamName(PORTUGAL);
        Team kor = teamRepository.getTeamByTeamName(SOUTH_KOREA);
        Team ury = teamRepository.getTeamByTeamName(URUGUAY);

        matchRepository.updatePoints(ury.getId(), kor.getId(), 0, 0);
        matchRepository.updatePoints(prt.getId(), gha.getId(), 3, 2);
        matchRepository.updatePoints(kor.getId(), gha.getId(), 2, 3);
        matchRepository.updatePoints(prt.getId(), ury.getId(), 2, 0);
        matchRepository.updatePoints(kor.getId(), prt.getId(), 2, 1);
        matchRepository.updatePoints(gha.getId(), ury.getId(), 0, 2);

    }
}
