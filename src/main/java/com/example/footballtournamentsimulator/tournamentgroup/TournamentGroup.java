package com.example.footballtournamentsimulator.tournamentgroup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "TournamentGroup")
@Table(name = "tournament_group")
@NoArgsConstructor
@ToString
@Getter
public class TournamentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tournament_group_name", columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private TournamentGroupName groupName;

    public TournamentGroup(TournamentGroupName groupName) {
        this.groupName = groupName;
    }
}
