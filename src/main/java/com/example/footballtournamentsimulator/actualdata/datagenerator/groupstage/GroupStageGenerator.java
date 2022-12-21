package com.example.footballtournamentsimulator.actualdata.datagenerator.groupstage;

import com.example.footballtournamentsimulator.actualdata.datagenerator.DataGenerator;

public class GroupStageGenerator implements DataGenerator {

    private final MatchGenerator matchGenerator;
    private final MatchResultsGenerator matchResultsGenerator;
    private final TournamentGroupGenerator tournamentGroupGenerator;

    public GroupStageGenerator(MatchGenerator matchGenerator, MatchResultsGenerator matchResultsGenerator, TournamentGroupGenerator tournamentGroupGenerator) {
        this.matchGenerator = matchGenerator;
        this.matchResultsGenerator = matchResultsGenerator;
        this.tournamentGroupGenerator = tournamentGroupGenerator;
    }

    @Override
    public void generate() {
        tournamentGroupGenerator.generate();
        matchGenerator.generate();
        matchResultsGenerator.generate();
    }
}
