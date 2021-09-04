package edu.volkov.mortalkombat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

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
            joinColumns = {@JoinColumn(name = "tournament_id")},
            inverseJoinColumns = {@JoinColumn(name = "fight_location_id")})
    private List<FightLocation> fightLocations = new ArrayList<>();

    @ToString.Exclude
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "fc_tournament_earthrealm_fighters",
            joinColumns = {@JoinColumn(name = "tournament_id")},
            inverseJoinColumns = {@JoinColumn(name = "earthrealm_fighters_id")})
    private List<Fighter> earthrealmFighters = new ArrayList<>();

    @ToString.Exclude
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "fc_tournament_outworld_fighters",
            joinColumns = {@JoinColumn(name = "tournament_id")},
            inverseJoinColumns = {@JoinColumn(name = "outworld_fighters_id")})
    private List<Fighter> outworldFighters = new ArrayList<>();

    @Formula("(SELECT COUNT(*) FROM Fight)")
    private int fightsCount;

    @Formula("(SELECT COUNT(*) FROM Fight f WHERE f.outworld_fighter_won = true)")
    private int outworldFightersWinsCount;

    @Formula("(SELECT COUNT(*) FROM Fight f WHERE f.earthrealm_fighter_won = true)")
    private int earthrealmFightersWinsCount;

    @Formula("(SELECT COUNT(*) FROM Fight f WHERE f.earthrealm_fighter_won = true AND f.someone_died = true)")
    private int outworldFightersDeathCount;

    @Formula("(SELECT COUNT(*) FROM Fight f WHERE f.outworld_fighter_won = true AND f.someone_died = true)")
    private int earthrealmFightersDeathCount;

    public Tournament(Integer id, String name) {
        super(id, name);
    }
}
