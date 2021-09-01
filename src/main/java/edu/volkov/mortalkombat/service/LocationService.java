package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Location;
import edu.volkov.mortalkombat.to.LocationTo;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends AbstractCrudService<LocationTo, Location, Integer> {
}
