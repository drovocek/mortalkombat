package edu.volkov.mortalkombat.to.util;

import edu.volkov.mortalkombat.model.Fighter;
import edu.volkov.mortalkombat.to.FighterTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FighterConverter implements DOConverter<FighterTo, Fighter> {

    private final FinishingOffConverter finishingOffConverter;

    @Override
    public FighterTo asTo(Fighter model) {
        FighterTo to = new FighterTo();
        to.setId(model.getId());
        to.setFinishingOffsTos(finishingOffConverter.asTos(model.getFinishingOffs()));
        to.setKingdom(model.getKingdom());
        to.setHealth(model.getHealth());
        to.setPunchPower(model.getPunchPower());
        return to;
    }

    @Override
    public Fighter asModel(FighterTo to) {
        return updateFromTo(new Fighter(), to);
    }

    @Override
    public Fighter updateFromTo(Fighter updated, FighterTo to) {
        updated.setId(to.getId());
        updated.setFinishingOffs(finishingOffConverter.asModels(to.getFinishingOffsTos()));
        updated.setKingdom(to.getKingdom());
        updated.setHealth(to.getHealth());
        updated.setPunchPower(to.getPunchPower());
        return updated;
    }
}
