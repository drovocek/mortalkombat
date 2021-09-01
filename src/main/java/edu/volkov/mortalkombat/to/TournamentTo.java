package edu.volkov.mortalkombat.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TournamentTo extends BaseTo<Integer> {

    private List<LocationTo> locationsTos;

    private List<FighterTo> defendersOfTheEarthTos;

    private List<FighterTo> attackerFromOutsideWorldTos;

    private int fightsCount;

    private int defendersWinsCount;

    private int attackersWinsCount;

    private int defendersDeathCount;

    private int attackersDeathCount;

    public TournamentTo(Integer id) {
        super(id);
    }
}
