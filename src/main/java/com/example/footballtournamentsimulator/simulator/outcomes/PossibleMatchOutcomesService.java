package com.example.footballtournamentsimulator.simulator.outcomes;

import com.example.footballtournamentsimulator.actualdata.match.MatchOutcome;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PossibleMatchOutcomesService {

    /**
     * @return the nine possible outcomes for a match day with two matches per group.
     */
    public List<PossibleGroupOutcomes> getAllPossibleOutcomesForADayMatch() {
        return Stream.of(MatchOutcome.values())
                .map(match1Result ->
                        Stream.of(MatchOutcome.values()).
                                map(match2Result -> new PossibleGroupOutcomes(match1Result, match2Result))
                                .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
