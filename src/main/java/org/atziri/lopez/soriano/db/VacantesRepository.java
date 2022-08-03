package org.atziri.lopez.soriano.db;

import org.atziri.lopez.soriano.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

}