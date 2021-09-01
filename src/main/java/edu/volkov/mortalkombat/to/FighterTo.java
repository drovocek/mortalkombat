package edu.volkov.mortalkombat.to;

import edu.volkov.mortalkombat.model.Kingdom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FighterTo extends BaseTo<Integer> {

    private List<FinishingOffTo> finishingOffsTos;

    private Kingdom kingdom;

    private int health;

    private int punchPower;

    public FighterTo(Integer id) {
        super(id);
    }
}
