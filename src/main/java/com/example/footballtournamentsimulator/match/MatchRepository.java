package com.example.footballtournamentsimulator.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "SELECT m FROM Match m WHERE m.tournamentGroup.id = :tournamentGroupId")
    List<Match> getMatchesByGroup(@Param("tournamentGroupId") long tournamentGroupId);

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
