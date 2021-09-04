package edu.volkov.mortalkombat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(exclude = "")
@NoArgsConstructor
@Entity
@Table(name = "fight_location")
public class FightLocation extends AbstractBaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "kingdom")
    private Kingdom kingdom;

    public FightLocation(Integer id, String name) {
        super(id, name);
    }
}
