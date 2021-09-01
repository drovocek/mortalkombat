package edu.volkov.mortalkombat.repository;

import edu.volkov.mortalkombat.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<Fighter, Integer> {
}
