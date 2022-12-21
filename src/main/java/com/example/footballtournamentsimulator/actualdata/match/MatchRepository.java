package com.example.footballtournamentsimulator.actualdata.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "SELECT m FROM Match m")
    List<Match> fetchAllMatches();

    /**
     * Fetches all matches up to the given match-day.
     *
     * @param matchDay ceiling (inclusive)
     * @return list of matches from day 1 to matchDay (inclusive).
     */
    @Query(value = "SELECT m FROM Match m WHERE m.matchDay <= :matchDay")
    List<Match> fetchMatchesUpToMatchDay(@Param("matchDay") int matchDay);

    @Query(value = "SELECT m FROM Match m WHERE m.matchDay = :matchDay AND m.tournamentGroup.id = :groupId")
    List<Match> fetchMatchesByMatchDayAndGroupId(@Param("matchDay") int matchDay, @Param("groupId") long groupId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Match m " +
            "SET m.homeTeamGoals = :homeTeamGoals, m.awayTeamGoals = :awayTeamGoals " +
            "WHERE m.homeTeam.id = :homeTeamId AND m.awayTeam.id = :awayTeamId")
    void updatePoints(@Param("homeTeamId") long homeTeamId,
                      @Param("awayTeamId") long awayTeamId,
                      @Param("homeTeamGoals") int homeTeamGoals,
                      @Param("awayTeamGoals") int awayTeamGoals);


}
