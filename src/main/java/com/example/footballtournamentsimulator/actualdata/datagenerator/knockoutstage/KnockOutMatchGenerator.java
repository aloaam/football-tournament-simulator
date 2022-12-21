package com.example.footballtournamentsimulator.actualdata.datagenerator.knockoutstage;

import com.example.footballtournamentsimulator.actualdata.datagenerator.DataGenerator;
import com.example.footballtournamentsimulator.actualdata.knockoutmatch.KnockOutMatch;
import com.example.footballtournamentsimulator.actualdata.knockoutmatch.KnockOutMatchRepository;
import com.example.footballtournamentsimulator.actualdata.team.TeamRepository;

import java.util.List;

import static com.example.footballtournamentsimulator.actualdata.knockoutmatch.KnockOutMatchType.ROUND_OF_16;
import static com.example.footballtournamentsimulator.actualdata.team.TeamName.*;

/**
 * This component generates data and stores it in the DB for the knock-out-phase
 * of the tournament.
 */
public class KnockOutMatchGenerator implements DataGenerator {

    private final TeamRepository teamRepository;
    private final KnockOutMatchRepository knockOutMatchRepository;


    public KnockOutMatchGenerator(TeamRepository teamRepository, KnockOutMatchRepository knockOutMatchRepository) {
        this.teamRepository = teamRepository;
        this.knockOutMatchRepository = knockOutMatchRepository;
    }


    @Override
    public void generate() {
        generateRoundOf16Matches();
    }

    private void generateRoundOf16Matches() {


        storeMatches(
                List.of(


                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(RB_LEIPZIG),
                                teamRepository.getTeamByTeamName(MANCHESTER_CITY),
                                ROUND_OF_16
                        ),
                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(CLUB_BRUGGE),
                                teamRepository.getTeamByTeamName(BENFICA),
                                ROUND_OF_16

                        ),
                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(LIVERPOOL),
                                teamRepository.getTeamByTeamName(REAL_MADRID),
                                ROUND_OF_16

                        ),
                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(AC_MILAN),
                                teamRepository.getTeamByTeamName(TOTTENHAM),
                                ROUND_OF_16

                        ),
                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(EINTRACHT_FRANKFURT),
                                teamRepository.getTeamByTeamName(NAPOLI),
                                ROUND_OF_16

                        ),
                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(DORTMUND),
                                teamRepository.getTeamByTeamName(CHELSEA),
                                ROUND_OF_16

                        ),
                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(INTER_MILAN),
                                teamRepository.getTeamByTeamName(PORTO),
                                ROUND_OF_16

                        ),
                        new KnockOutMatch(
                                teamRepository.getTeamByTeamName(PARIS_SAINT_GERMAIN),
                                teamRepository.getTeamByTeamName(BAYERN_MUNICH),
                                ROUND_OF_16

                        )

                )

        );

    }

    //TODO: Alo - create saveall query in the repo.
    private void storeMatches(List<KnockOutMatch> matches) {
        knockOutMatchRepository.saveAll(matches);
    }

}
