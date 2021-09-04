package edu.volkov.mortalkombat.to;

import edu.volkov.mortalkombat.model.Kingdom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FightLocationTo extends BaseTo<Integer> {

    private Kingdom kingdom;

    public FightLocationTo(Integer id, String name) {
        super(id, name);
    }
}
