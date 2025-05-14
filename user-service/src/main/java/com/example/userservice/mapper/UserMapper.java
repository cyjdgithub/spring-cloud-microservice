package com.example.userservice.mapper;

import com.example.userservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserMapper {
    private final Map<Long, User> userDb = new HashMap<>();

    public UserMapper() {
        userDb.put(1L, new User(1L, "Alice", "alice@example.com"));
        userDb.put(2L, new User(2L, "Bob", "bob@example.com"));
    }

    public User findById(Long id) {
        return userDb.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(userDb.values());
    }

    public void save(User user) {
        userDb.put(user.getId(), user);
    }
}
