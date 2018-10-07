package org.prezydium.databasing.dao;

import org.prezydium.databasing.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, Long> {
}
