package edu.volkov.mortalkombat.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TournamentTo extends BaseTo<Integer> {

    private List<FightLocationTo> locationsTos;

    private List<FighterTo> earthrealmFighterTos;

    private List<FighterTo> outworldFighterTos;

    private int fightsCount;

    private int outworldFightersWinsCount;

    private int earthrealmFightersWinsCount;

    private int outworldFightersDeathCount;

    private int earthrealmFightersDeathCount;

    public TournamentTo(Integer id, String name) {
        super(id, name);
    }
}
