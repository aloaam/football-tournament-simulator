package com.example.footballtournamentsimulator.simulator.outcomes;

import com.example.footballtournamentsimulator.match.MatchResult;

/**
 * Holds the possible outcomes for a match day with two matches.
 * @param result1
 * @param result2
 */
public record PossibleMatchOutcomes(MatchResult result1, MatchResult result2) {
}
