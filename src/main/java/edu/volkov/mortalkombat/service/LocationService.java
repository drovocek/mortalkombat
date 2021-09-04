package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Location;
import edu.volkov.mortalkombat.to.LocationTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends AbstractCrudService<LocationTo, Location, Integer> {

    public LocationService(JpaRepository<Location, Integer> repository, DOConverter<LocationTo, Location> converter) {
        super(repository, converter);
    }
}
