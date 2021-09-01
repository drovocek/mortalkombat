package edu.volkov.mortalkombat.repository;

import edu.volkov.mortalkombat.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
