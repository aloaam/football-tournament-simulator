package com.example.footballtournamentsimulator.simulator.outcomes;

import com.example.footballtournamentsimulator.match.MatchResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PossibleMatchOutcomesService {

    /**
     * @return the nine possible outcomes for a match day with two matches per group.
     */
    public List<PossibleMatchOutcomes> getAllPossibleOutcomesForADayMatch() {
        return Stream.of(MatchResult.values())
                .map(match1Result ->
                        Stream.of(MatchResult.values()).
                                map(match2Result -> new PossibleMatchOutcomes(match1Result, match2Result))
                                .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
