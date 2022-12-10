package com.example.footballtournamentsimulator.team;

import com.example.footballtournamentsimulator.tournamentgroup.TournamentGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Team")
@Table(name = "team")
@NoArgsConstructor
@ToString
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "team_name", nullable = false, columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private TeamName teamName;

    @Column(name = "points", nullable = false)
    private int points;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_group_id", foreignKey = @ForeignKey(name = "team_tournament_group_fk"))
    private TournamentGroup tournamentGroupId;

    public Team(TeamName teamName, int points, TournamentGroup tournamentGroupId) {
        this.teamName = teamName;
        this.points = points;
        this.tournamentGroupId = tournamentGroupId;
    }

}
