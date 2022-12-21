package com.example.footballtournamentsimulator.actualdata.tournamentgroup;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "tournament_group_name", unique = true, columnDefinition = "TEXT")
    private TournamentGroupName groupName;

    public TournamentGroup(TournamentGroupName groupName) {
        this.groupName = groupName;
    }
}
