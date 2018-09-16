package org.prezydium.caching.dao;

import org.prezydium.caching.model.DevEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperDao extends JpaRepository<DevEntity, Long> {
}
