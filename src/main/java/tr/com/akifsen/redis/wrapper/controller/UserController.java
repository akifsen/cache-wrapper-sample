package tr.com.akifsen.redis.wrapper.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.akifsen.redis.wrapper.model.User;
import tr.com.akifsen.redis.wrapper.service.CacheService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CacheService cacheService;

    @PostMapping("/add")
    public String addUserToCache(@RequestParam String key, @RequestParam String name, @RequestParam int age) {
        User user = new User(name, age);
        cacheService.addUserToCache(key, user, 60); // 60 saniye timeout
        return "User added to cache!";
    }

    @GetMapping("/get")
    public User getUserFromCache(@RequestParam String key) {
        return cacheService.getUserFromCache(key);
    }
}