package edu.volkov.mortalkombat.to.util;

import edu.volkov.mortalkombat.model.FightLocation;
import edu.volkov.mortalkombat.to.FightLocationTo;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter implements DOConverter<FightLocationTo, FightLocation> {

    @Override
    public FightLocationTo asTo(FightLocation model) {
        FightLocationTo to = new FightLocationTo();
        to.setId(model.getId());
        to.setName(model.getName());
        to.setKingdom(model.getKingdom());
        return to;
    }

    @Override
    public FightLocation asModel(FightLocationTo to) {
        return updateFromTo(new FightLocation(), to);
    }

    @Override
    public FightLocation updateFromTo(FightLocation updated, FightLocationTo to) {
        updated.setId(to.getId());
        updated.setName(to.getName());
        updated.setKingdom(to.getKingdom());
        return updated;
    }
}
