package com.jwt.example.service;


import com.jwt.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(), "Akash Payal", "akash.pyal22@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Anshu Pujita", "anshu.pujita11@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Sky", "sky22@gmail.com"));
    }

    public List<User> getUsers() {
        return store;
    }
}
