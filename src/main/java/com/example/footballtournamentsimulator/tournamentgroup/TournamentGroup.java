package com.example.footballtournamentsimulator.tournamentgroup;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Group")
@Table(name = "tournament_group")
@NoArgsConstructor
@ToString
public class TournamentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private GroupName groupName;

    public TournamentGroup(GroupName groupName) {
        this.groupName = groupName;
    }
}
