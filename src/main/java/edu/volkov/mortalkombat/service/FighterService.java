package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Fighter;
import edu.volkov.mortalkombat.to.FighterTo;
import org.springframework.stereotype.Service;

@Service
public class FighterService extends AbstractCrudService<FighterTo, Fighter, Integer> {
}
