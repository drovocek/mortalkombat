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
        to.setName(model.getName());
        to.setLocationsTos(locationConverter.asTos(model.getFightLocations()));
        to.setEarthrealmFighterTos(fighterConverter.asTos(model.getEarthrealmFighters()));
        to.setOutworldFighterTos(fighterConverter.asTos(model.getOutworldFighters()));
        to.setEarthrealmFightersWinsCount(model.getEarthrealmFightersWinsCount());
        to.setOutworldFightersWinsCount(model.getOutworldFightersWinsCount());
        to.setEarthrealmFightersDeathCount(model.getEarthrealmFightersDeathCount());
        to.setOutworldFightersDeathCount(model.getOutworldFightersDeathCount());
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
        updated.setName(to.getName());
        return updated;
    }
}
