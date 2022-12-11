package com.example.footballtournamentsimulator.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "SELECT t.points FROM Team t WHERE t.id = :teamId")
    int getPointsByTeamId(@Param("teamId") long teamId);

    @Query(value = "SELECT t FROM Team t WHERE t.teamName = ?1")
    Team getTeamByTeamName(TeamName name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Team t SET t.points = ?1 WHERE t.id = ?2")
    void updateTeamPoints(int points, long id);

}
