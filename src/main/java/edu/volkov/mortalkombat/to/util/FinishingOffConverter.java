package edu.volkov.mortalkombat.to.util;

import edu.volkov.mortalkombat.model.FinishingOff;
import edu.volkov.mortalkombat.to.FinishingOffTo;
import org.springframework.stereotype.Component;

@Component
public class FinishingOffConverter implements DOConverter<FinishingOffTo, FinishingOff> {

    @Override
    public FinishingOffTo asTo(FinishingOff model) {
        FinishingOffTo to = new FinishingOffTo();
        to.setId(model.getId());
        to.setFinishType(model.getFinishType());
        to.setComplexity(model.getComplexity());
        to.setShowy(model.getShowy());
        return to;
    }

    @Override
    public FinishingOff asModel(FinishingOffTo to) {
        return updateFromTo(new FinishingOff(), to);
    }

    @Override
    public FinishingOff updateFromTo(FinishingOff updated, FinishingOffTo to) {
        updated.setId(to.getId());
        updated.setFinishType(to.getFinishType());
        updated.setComplexity(to.getComplexity());
        updated.setShowy(to.getShowy());
        return updated;
    }
}
