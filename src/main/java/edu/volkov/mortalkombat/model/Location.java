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
@Table(name = "location")
public class Location extends AbstractBaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "kingdom")
    private Kingdom kingdom;

    public Location(Integer id, String name) {
        super(id, name);
    }
}
