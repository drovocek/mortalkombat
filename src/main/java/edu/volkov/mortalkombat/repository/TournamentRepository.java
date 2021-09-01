package edu.volkov.mortalkombat.repository;

import edu.volkov.mortalkombat.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
