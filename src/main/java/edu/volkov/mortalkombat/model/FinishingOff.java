package edu.volkov.mortalkombat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "finishing_off")
public class FinishingOff extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fighter_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fighter fighter;

    @Enumerated(EnumType.STRING)
    @Column(name = "finish_type")
    private FinishType finishType;

    @NotNull
    @Column(name = "showy")
    private int showy;

    @NotNull
    @Column(name = "complexity")
    private int complexity;

    public FinishingOff(Integer id, String name) {
        super(id, name);
    }
}
