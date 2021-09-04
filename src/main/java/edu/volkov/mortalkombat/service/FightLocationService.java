package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.FightLocation;
import edu.volkov.mortalkombat.to.FightLocationTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FightLocationService extends AbstractCrudService<FightLocationTo, FightLocation, Integer> {

    public FightLocationService(JpaRepository<FightLocation, Integer> repository, DOConverter<FightLocationTo, FightLocation> converter) {
        super(repository, converter);
    }
}
