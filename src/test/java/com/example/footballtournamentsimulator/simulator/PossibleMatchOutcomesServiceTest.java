package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.simulator.outcomes.PossibleMatchOutcomes;
import com.example.footballtournamentsimulator.simulator.outcomes.PossibleMatchOutcomesService;
import org.junit.jupiter.api.Test;

import java.util.List;

class PossibleMatchOutcomesServiceTest {

    final PossibleMatchOutcomesService unit = new PossibleMatchOutcomesService();

    @Test
    void getAllPossibleOutcomesForADayMatch() {
        List<PossibleMatchOutcomes> allPossibleOutcomesForADayMatch = unit.getAllPossibleOutcomesForADayMatch();
        allPossibleOutcomesForADayMatch.forEach(System.out::println);
    }
}