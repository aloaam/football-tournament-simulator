package com.example.footballtournamentsimulator.match;

import com.example.footballtournamentsimulator.team.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "Match")
@Table(name = "match")
@NoArgsConstructor
@ToString
@Getter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id", foreignKey = @ForeignKey(name = "home_team_fk"))
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", foreignKey = @ForeignKey(name = "away_team_fk"))
    private Team awayTeam;


    @Column(name = "match_day")
    private int matchDay;

    @Column(name = "match_result", columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private MatchResult matchResult;

    public Match(Team homeTeam, Team awayTeam, int matchDay) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDay = matchDay;
    }

    public Match(Team homeTeam, Team awayTeam, int matchDay, MatchResult matchResult) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDay = matchDay;
        this.matchResult = matchResult;
    }

    public Team getWinnerTeam(MatchResult matchResult) {
        if (matchResult.equals(MatchResult.AWAY_TEAM_WIN)) {
            return awayTeam;
        }
        if (matchResult.equals(MatchResult.HOME_TEAM_WIN)) {
            return homeTeam;
        }
        //TODO: Alo - fix this
        throw new RuntimeException("Error here");
    }
}
