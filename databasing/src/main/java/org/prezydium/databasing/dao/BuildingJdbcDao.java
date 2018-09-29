package org.prezydium.databasing.dao;

import org.prezydium.databasing.model.BuildingFromDB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class BuildingJdbcDao {

    private String sqlQuery = "SELECT\n" +
            "BUILDINGS.ID,\n" +
            "BUILDINGS.BUILDING_TYPE,\n" +
            "ADDRESSES.CITY,\n" +
            "ADDRESSES.STREET,\n" +
            "ADDRESSES.NUMBER\n" +
            "FROM BUILDINGS\n" +
            "INNER JOIN\n" +
            "ADDRESSES ON ADDRESSES.ID = BUILDINGS.ADDRESS_ID";

    private final JdbcTemplate jdbcTemplate;


    public BuildingJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BuildingFromDB> getAll() throws IOException {
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sqlQuery);
        resultList.forEach(x -> x.values().forEach(System.out::println));
        return null;
    }
}
