package org.prezydium.caching.service;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class ManualClearCacheService {

    private final CacheManager cacheManager;

    public ManualClearCacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    //wonderful place to place @Scheduled ! ;)
    public void clearCache(){
        cacheManager.getCacheNames().parallelStream().forEach(name -> cacheManager.getCache(name).clear());
    }
}
