package com.example.footballtournamentsimulator.simulator.outcomes;

import com.example.footballtournamentsimulator.match.MatchOutcome;

import java.util.List;

//TODO: ALO - change name to outcomeForMatch1, and ...2
/**
 * Holds the possible outcomes for a match day with two matches.
 *
 * @param outcome1
 * @param outcome2
 */
public record PossibleGroupOutcomes(MatchOutcome outcome1, MatchOutcome outcome2) {

    public List<MatchOutcome> getOutcomes() {
        return List.of(outcome1, outcome2);
    }
}


//TODO: Alo - when i learn how to do tests, add this test back.
//class PossibleGroupOutcomesServiceTest {
//
//    final PossibleMatchOutcomesService unit = new PossibleMatchOutcomesService();
//
//    @Test
//    void getAllPossibleOutcomesForADayMatch() {
//        List<PossibleGroupOutcomes> allPossibleOutcomesForADayMatch = unit.getAllPossibleOutcomesForADayMatch();
//        allPossibleOutcomesForADayMatch.forEach(System.out::println);
//    }
//}
