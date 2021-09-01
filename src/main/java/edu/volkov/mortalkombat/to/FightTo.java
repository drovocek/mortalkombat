package edu.volkov.mortalkombat.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FightTo extends BaseTo<Integer> {

    private Integer tournamentId;

    private FighterTo earthrealmFighterTo;

    private FighterTo outworldFighterTo;

    private LocationTo locationTo;

    private boolean isEarthrealmFighterWon;

    private boolean isOutworldFighterWon;

    private boolean isSomeoneDied;

    public FightTo(Integer id) {
        super(id);
    }
}
