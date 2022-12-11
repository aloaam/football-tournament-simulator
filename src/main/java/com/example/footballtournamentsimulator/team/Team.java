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

    //TODO: ALO - add default value
    @Column(name = "points")
    private int points;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tournament_group_id", foreignKey = @ForeignKey(name = "team_tournament_group_fk"))
    private TournamentGroup tournamentGroupId;

    public Team(TeamName teamName, TournamentGroup tournamentGroupId) {
        this.teamName = teamName;
        this.tournamentGroupId = tournamentGroupId;
    }

}
