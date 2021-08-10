package com.example.blog.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {

    private final HashMap<Long, User> users = new HashMap<>();

    public User findById(Long id) {
        return users.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }
}
