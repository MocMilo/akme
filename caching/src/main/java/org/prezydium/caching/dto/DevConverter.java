package org.prezydium.caching.dto;


import org.prezydium.caching.model.DevEntity;
import org.prezydium.caching.model.DevFormModel;
import org.springframework.stereotype.Service;

@Service
public class DevConverter {


    public DevEntity convertFormToEntity(DevFormModel devFormModel){
        return new DevEntity(
                devFormModel.getFirstName(),
                devFormModel.getLastName(),
                devFormModel.getSalary(),
                devFormModel.getGender(),
                devFormModel.getKnownLanguages()
        );
    }

    public DevFormModel convertEntityToForm(DevEntity devEntity){
        return new DevFormModel(
                devEntity.getId(),
                devEntity.getFirstName(),
                devEntity.getLastName(),
                devEntity.getSalary(),
                devEntity.getGender(),
                devEntity.getKnownLanguages()
        );
    }
}
