package edu.volkov.mortalkombat.repository;

import edu.volkov.mortalkombat.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FightRepository extends JpaRepository<Fight, Integer> {
}
