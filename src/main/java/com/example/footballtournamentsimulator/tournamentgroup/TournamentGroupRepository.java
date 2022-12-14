package com.example.footballtournamentsimulator.tournamentgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentGroupRepository extends JpaRepository<TournamentGroup, Long> {

    @Query(value = "SELECT tg FROM TournamentGroup tg")
    List<TournamentGroup> getAllGroups();


    @Query(value = "SELECT tg FROM TournamentGroup tg WHERE tg.groupName = :tournamentGroupName")
    TournamentGroup getTournamentGroupByName(@Param("tournamentGroupName") TournamentGroupName tournamentGroupName);

}
