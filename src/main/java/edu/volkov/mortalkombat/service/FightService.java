package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Fight;
import edu.volkov.mortalkombat.to.FightTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FightService extends AbstractCrudService<FightTo, Fight, Integer> {

    public FightService(JpaRepository<Fight, Integer> repository, DOConverter<FightTo, Fight> converter) {
        super(repository, converter);
    }
}
