package com.example.footballtournamentsimulator.actualdata.matchday;

import com.example.footballtournamentsimulator.actualdata.match.Match;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroup;

import java.util.List;

/**
 * Holds two matches which represent a matchDay in a group.
 */
public record MatchDay(TournamentGroup group, Match match1, Match match2, int matchDay) {

    public static MatchDay from(List<Match> matches) {

        final int listSize = matches.size();
        if (listSize > 2) {
            throw new IllegalArgumentException("A match-day can only have two matches per group. An instance" +
                    "of a MatchDay was trying to be created with a list of matches of size: " + listSize);
        }

        final Match match0 = matches.get(0);
        final Match match1 = matches.get(1);
        final long groupIdMatch0 = match0.getTournamentGroup().getId();
        final long groupIdMatch1 = match1.getTournamentGroup().getId();

        final int matchDay0 = match0.getMatchDay();
        final int matchDay1 = match1.getMatchDay();

        if (matchDay0 != matchDay1) {
            throw new IllegalArgumentException(String.format("The two matches sent to construct the MatchDay, should belong to" +
                    "the same match-day, the values sent for match1 and match2 were: %s, and %s were: ", matchDay0, matchDay1));
        }

        if (groupIdMatch0 != groupIdMatch1) {
            throw new IllegalArgumentException(String.format("The two matches sent to construct the MatchDay, should belong to" +
                    "the same TournamentGroup, the ids sent for match1 and match2 were: %s, and %s were ", groupIdMatch0, groupIdMatch1));
        }

        return new MatchDay(match0.getTournamentGroup(), match0, match1, matchDay0);
    }

}
