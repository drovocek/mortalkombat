package edu.volkov.mortalkombat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "tournament")
public class Tournament extends AbstractBaseEntity {

    @ToString.Exclude
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "fc_tournament_location",
            joinColumns = {@JoinColumn(name = "id_tournament")},
            inverseJoinColumns = {@JoinColumn(name = "id_location")})
    private List<Location> locations = new ArrayList<>();

    @ToString.Exclude
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "fc_tournament_defender",
            joinColumns = {@JoinColumn(name = "id_tournament")},
            inverseJoinColumns = {@JoinColumn(name = "id_defender")})
    private List<Fighter> defendersOfTheEarth = new ArrayList<>();

    @ToString.Exclude
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "fc_tournament_attackers",
            joinColumns = {@JoinColumn(name = "id_tournament")},
            inverseJoinColumns = {@JoinColumn(name = "id_attackers")})
    private List<Fighter> attackerFromOutsideWorld = new ArrayList<>();

    @Column(name = "fights_count")
    private int fightsCount;

    @Column(name = "defenders_wins_count")
    private int defendersWinsCount;

    @Column(name = "attackers_wins_count")
    private int attackersWinsCount;

    @Column(name = "defenders_death_count")
    private int defendersDeathCount;

    @Column(name = "attackers_death_count")
    private int attackersDeathCount;

    public Tournament(Integer id, String name) {
        super(id, name);
    }
}
