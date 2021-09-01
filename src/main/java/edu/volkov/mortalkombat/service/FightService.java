package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Fight;
import edu.volkov.mortalkombat.to.FightTo;
import org.springframework.stereotype.Service;

@Service
public class FightService extends AbstractCrudService<FightTo, Fight, Integer> {
}
