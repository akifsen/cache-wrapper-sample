package tr.com.akifsen.redis.wrapper.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.akifsen.redis.wrapper.service.RedisCacheService;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisCacheService redisCacheWrapper;

    @GetMapping("/add")
    public String addToCache(@RequestParam String key, @RequestParam String value, @RequestParam long timeout) {
        redisCacheWrapper.set(key, value, timeout, TimeUnit.SECONDS);
        return "Added to cache!";
    }

    @GetMapping("/get")
    public Object getFromCache(@RequestParam String key) {
        return redisCacheWrapper.get(key);
    }

    @DeleteMapping("/remove")
    public String removeFromCache(@RequestParam String key) {
        redisCacheWrapper.delete(key);
        return "Removed from cache!";
    }

    @GetMapping("/exists")
    public boolean isKeyExists(@RequestParam String key) {
        return redisCacheWrapper.hasKey(key);
    }
}