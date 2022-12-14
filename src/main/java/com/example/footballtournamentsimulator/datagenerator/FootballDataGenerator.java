package com.example.footballtournamentsimulator.datagenerator;

import lombok.extern.slf4j.Slf4j;

/**
 * Creates data to fill-in the DB.
 */
@Slf4j
public class FootballDataGenerator implements DataGenerator {

    private final MatchGenerator matchGenerator;
    private final MatchResultsGenerator matchResultsGenerator;
    private final TournamentGroupGenerator tournamentGroupGenerator;

    public FootballDataGenerator(MatchGenerator matchGenerator, MatchResultsGenerator matchResultsGenerator, TournamentGroupGenerator tournamentGroupGenerator) {
        this.matchGenerator = matchGenerator;
        this.matchResultsGenerator = matchResultsGenerator;
        this.tournamentGroupGenerator = tournamentGroupGenerator;
    }

    @Override
    public void generate() {
        log.info("Generating data in the DB...");
        tournamentGroupGenerator.generate();
        matchGenerator.generate();
        matchResultsGenerator.generate();
        log.info("Data in the DB generated.");
    }
}
