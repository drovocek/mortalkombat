package edu.volkov.mortalkombat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "fighter")
public class Fighter extends AbstractBaseEntity {

    @NotEmpty
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fighter")
    private List<FinishingOff> finishingOffs = new ArrayList<>();

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "kingdom")
    private Kingdom kingdom;

    @Column(name = "health")
    private int health;

    @Column(name = "punch_power")
    private int punchPower;

    public Fighter(Integer id, String name) {
        super(id, name);
    }
}
