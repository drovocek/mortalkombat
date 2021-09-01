package edu.volkov.mortalkombat.to.util;

import edu.volkov.mortalkombat.model.Location;
import edu.volkov.mortalkombat.to.LocationTo;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter implements DOConverter<LocationTo, Location> {

    @Override
    public LocationTo asTo(Location model) {
        LocationTo to = new LocationTo();
        to.setId(model.getId());
        to.setKingdom(model.getKingdom());
        return to;
    }

    @Override
    public Location asModel(LocationTo to) {
        return updateFromTo(new Location(), to);
    }

    @Override
    public Location updateFromTo(Location updated, LocationTo to) {
        updated.setId(to.getId());
        updated.setKingdom(to.getKingdom());
        return updated;
    }
}
