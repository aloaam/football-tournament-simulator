package com.example.footballtournamentsimulator.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Modifying
    @Query(value = "UPDATE Team t SET t.points = ?1 WHERE t.id = ?2")
    int updateTeamPoints(int points, long id);
}
