package org.prezydium.caching.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomColorGeneratorService {

    @Cacheable("color")
    public Integer[] generateRandomRGB(int buttonNumber){
        Integer[] rgbArr = new Integer[3];
        rgbArr[0] = new Random().nextInt(256);
        rgbArr[1] = new Random().nextInt(256);
        rgbArr[2] = new Random().nextInt(256);
        return rgbArr;
    }

}
