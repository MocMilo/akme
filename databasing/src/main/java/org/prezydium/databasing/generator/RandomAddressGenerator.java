package org.prezydium.databasing.generator;


import org.prezydium.databasing.model.Address;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class RandomAddressGenerator {

    private final List<String> listOfCities = Arrays.asList("GDANSK", "GDYNIA", "SOPOT", "TCZEW", "SLUPSK");

    public Address generateRandomAddress() {
        Address address = new Address();
        address.setCity(randomCity());

        return address;
    }


    private String randomCity() {
        int boundaryOfRandomCities = listOfCities.size();
        int indexOfRandomCity = new Random().nextInt(boundaryOfRandomCities);
        return listOfCities.get(indexOfRandomCity);
    }
}
