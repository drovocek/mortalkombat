package edu.volkov.mortalkombat.to.util;

import edu.volkov.mortalkombat.model.Tournament;
import edu.volkov.mortalkombat.to.TournamentTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TournamentConverter implements DOConverter<TournamentTo, Tournament> {

    private final LocationConverter locationConverter;
    private final FighterConverter fighterConverter;

    @Override
    public TournamentTo asTo(Tournament model) {
        TournamentTo to = new TournamentTo();
        to.setId(model.getId());
        to.setLocationsTos(locationConverter.asTos(model.getLocations()));
        to.setDefendersOfTheEarthTos(fighterConverter.asTos(model.getDefendersOfTheEarth()));
        to.setAttackerFromOutsideWorldTos(fighterConverter.asTos(model.getAttackerFromOutsideWorld()));
        to.setAttackersWinsCount(model.getAttackersWinsCount());
        to.setAttackersDeathCount(model.getAttackersDeathCount());
        to.setDefendersWinsCount(model.getDefendersWinsCount());
        to.setDefendersDeathCount(model.getDefendersDeathCount());
        to.setFightsCount(model.getFightsCount());
        return to;
    }

    @Override
    public Tournament asModel(TournamentTo to) {
        return updateFromTo(new Tournament(), to);
    }

    @Override
    public Tournament updateFromTo(Tournament updated, TournamentTo to) {
        updated.setId(to.getId());
        return updated;
    }
}
