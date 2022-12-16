package com.example.footballtournamentsimulator.team;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "SELECT t.points FROM Team t WHERE t.id = :teamId")
    int getPointsByTeamId(@Param("teamId") long teamId);

    @Query(value = "SELECT t FROM Team t WHERE t.teamName = :teamName")
    Team getTeamByTeamName(@Param("teamName") TeamName teamName);

    @Query(value = "SELECT t FROM Team t WHERE t.tournamentGroupId.id = :groupId")
    List<Team> getTeamsByTournamentGroupId(@Param("groupId") long groupId, Sort sort);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Team t SET t.points = :points WHERE t.id = :teamId")
    void updateTeamPoints(@Param("points") int points, @Param("teamId") long teamId);

}
