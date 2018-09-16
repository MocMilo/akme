package org.prezydium.caching.dao;

import org.prezydium.caching.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Employee, Long> {
}
