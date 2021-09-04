package edu.volkov.mortalkombat.repository;

import edu.volkov.mortalkombat.model.FightLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FightLocationRepository extends JpaRepository<FightLocation, Integer> {
}
