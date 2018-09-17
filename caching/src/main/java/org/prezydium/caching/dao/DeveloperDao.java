package org.prezydium.caching.dao;

import org.prezydium.caching.model.DevEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperDao extends JpaRepository<DevEntity, Long> {

    @Override
    @Cacheable(value = "devs", key = "#root.methodName")
    List<DevEntity> findAll();
}
