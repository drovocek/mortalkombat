package edu.volkov.mortalkombat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "fight")
public class Fight extends AbstractBaseEntity {

    @ToString.Exclude
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "earthrealm_fighter_id", referencedColumnName = "id")
    private Fighter earthrealmFighter;

    @ToString.Exclude
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "outworld_fighter_id", referencedColumnName = "id")
    private Fighter outworldFighter;

    @ToString.Exclude
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id", referencedColumnName = "id")
    private Tournament tournament;

    @ToString.Exclude
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Column(name = "earthrealm_fighter_won")
    private boolean isEarthrealmFighterWon;

    @Column(name = "outworld_fighter_won")
    private boolean isOutworldFighterWon;

    @Column(name = "someone_died")
    private boolean isSomeoneDied;

    public Fight(Integer id, String name) {
        super(id, name);
    }
}
