package tr.com.akifsen.redis.wrapper.service;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.akifsen.redis.wrapper.model.User;

@Service
public class CacheService {

    @Autowired
    private RedisCacheService redisCacheService;

    public void addUserToCache(String key, User user, long timeout) {
    	redisCacheService.set(key, user, timeout, TimeUnit.SECONDS);
    }

    public User getUserFromCache(String key) {
        return (User) redisCacheService.get(key);
    }
}