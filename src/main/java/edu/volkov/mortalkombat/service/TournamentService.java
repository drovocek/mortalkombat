package edu.volkov.mortalkombat.service;

import edu.volkov.mortalkombat.model.Tournament;
import edu.volkov.mortalkombat.to.TournamentTo;
import edu.volkov.mortalkombat.to.util.DOConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TournamentService extends AbstractCrudService<TournamentTo, Tournament, Integer> {

    public TournamentService(JpaRepository<Tournament, Integer> repository, DOConverter<TournamentTo, Tournament> converter) {
        super(repository, converter);
    }
}
