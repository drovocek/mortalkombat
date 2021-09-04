package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.FinishingOff;
import edu.volkov.mortalkombat.to.FinishingOffTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FinishingOffService extends AbstractCrudService<FinishingOffTo, FinishingOff, Integer> {

    public FinishingOffService(JpaRepository<FinishingOff, Integer> repository, DOConverter<FinishingOffTo, FinishingOff> converter) {
        super(repository, converter);
    }
}
