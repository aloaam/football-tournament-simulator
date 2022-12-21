package com.example.footballtournamentsimulator.actualdata.knockoutmatch;


import com.example.footballtournamentsimulator.actualdata.team.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "KnockOutMatch")
@Table(name = "knock_out_match")
@NoArgsConstructor
@ToString
@Getter
public class KnockOutMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_type", columnDefinition = "TEXT")
    private KnockOutMatchType knockOutMatchType;

    @ManyToOne
    @JoinColumn(name = "home_team_id", foreignKey = @ForeignKey(name = "home_team_fk"))
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", foreignKey = @ForeignKey(name = "away_team_fk"))
    private Team awayTeam;

    @Column(name = "home_team_goals")
    private int homeTeamGoals;

    @Column(name = "away_team_goals")
    private int awayTeamGoals;

    public KnockOutMatch(Team homeTeam, Team awayTeam, KnockOutMatchType knockOutMatchType) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.knockOutMatchType = knockOutMatchType;

    }
}
