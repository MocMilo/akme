package org.prezydium.databasing.generator;


import org.prezydium.databasing.dao.BuildingDao;
import org.prezydium.databasing.model.Building;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseFiller {

    private final RandomBuildingGenerator randomBuildingGenerator;

    private final BuildingDao buildingDao;

    public DatabaseFiller(RandomBuildingGenerator randomBuildingGenerator, BuildingDao buildingDao) {
        this.randomBuildingGenerator = randomBuildingGenerator;
        this.buildingDao = buildingDao;
    }

    @RequestMapping(value = "/fill/{number}")
    public String populateDatabaseWithRandomData(@PathVariable("number") int number){
        for (int i = 0; i < number; i++){
            Building building = randomBuildingGenerator.generateRandomBuilding();
            buildingDao.save(building);
        }
        return "Database filled with random data containing" + number + "buildings";
    }
}
