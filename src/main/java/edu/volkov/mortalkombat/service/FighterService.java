package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Fighter;
import edu.volkov.mortalkombat.to.FighterTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FighterService extends AbstractCrudService<FighterTo, Fighter, Integer> {

    public FighterService(JpaRepository<Fighter, Integer> repository, DOConverter<FighterTo, Fighter> converter) {
        super(repository, converter);
    }
}
