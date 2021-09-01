package edu.volkov.mortalkombat.to.util;

import edu.volkov.mortalkombat.model.Fight;
import edu.volkov.mortalkombat.model.Tournament;
import edu.volkov.mortalkombat.to.FightTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FightConverter implements DOConverter<FightTo, Fight> {

    private final FighterConverter fighterConverter;

    @Override
    public FightTo asTo(Fight model) {
        FightTo to = new FightTo();
        to.setId(model.getId());
        to.setEarthrealmFighterTo(fighterConverter.asTo(model.getEarthrealmFighter()));
        to.setOutworldFighterTo(fighterConverter.asTo(model.getOutworldFighter()));
        to.setTournamentId(model.getTournament().getId());
        to.setEarthrealmFighterWon(model.isEarthrealmFighterWon());
        to.setOutworldFighterWon(model.isOutworldFighterWon());
        to.setSomeoneDied(model.isSomeoneDied());
        return to;
    }

    @Override
    public Fight asModel(FightTo to) {
        return updateFromTo(new Fight(), to);
    }

    @Override
    public Fight updateFromTo(Fight updated, FightTo to) {
        updated.setId(to.getId());
        updated.setEarthrealmFighter(fighterConverter.asModel(to.getEarthrealmFighterTo()));
        updated.setOutworldFighter(fighterConverter.asModel(to.getOutworldFighterTo()));
        updated.setEarthrealmFighterWon(to.isEarthrealmFighterWon());
        updated.setOutworldFighterWon(to.isOutworldFighterWon());
        updated.setSomeoneDied(to.isSomeoneDied());

        Tournament tournament = new Tournament();
        tournament.setId(to.getTournamentId());
        updated.setTournament(tournament);
        return updated;
    }
}
