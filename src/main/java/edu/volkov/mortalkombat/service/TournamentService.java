package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Tournament;
import edu.volkov.mortalkombat.to.TournamentTo;
import org.springframework.stereotype.Service;

@Service
public class TournamentService extends AbstractCrudService<TournamentTo, Tournament, Integer> {
}
