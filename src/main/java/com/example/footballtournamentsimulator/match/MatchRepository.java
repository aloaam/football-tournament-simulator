package com.example.footballtournamentsimulator.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m WHERE m.matchDay = :matchDay")
    Optional<List<Match>> findMatchesByMatchDay(@Param("matchDay") int matchDay);
}
