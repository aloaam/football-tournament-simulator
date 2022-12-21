package com.example.footballtournamentsimulator.actualdata.match;

import com.example.footballtournamentsimulator.actualdata.team.Team;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "Match")
@Table(name = "match")
@NoArgsConstructor
@ToString
@Getter
/**
 * This object represents a group-phase-match.
 */
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

    @ManyToOne
    @JoinColumn(name = "tournament_group_id", foreignKey = @ForeignKey(name = "tournament_group_fk"), nullable = false)
    private TournamentGroup tournamentGroup;

    @Column(name = "match_day")
    private int matchDay;

    @Column(name = "home_team_goals")
    private int homeTeamGoals;

    @Column(name = "away_team_goals")
    private int awayTeamGoals;

    public Match(Team homeTeam, Team awayTeam, TournamentGroup tournamentGroup, int matchDay) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.tournamentGroup = tournamentGroup;
        this.matchDay = matchDay;
    }

}
