package org.prezydium.caching.dao;

import org.prezydium.caching.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperDao extends JpaRepository<Developer, Long> {
}
