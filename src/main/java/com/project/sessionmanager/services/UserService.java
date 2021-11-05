package com.project.sessionmanager.services;

import com.project.sessionmanager.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list = new ArrayList<User>();

    public UserService() {
        list.add(new User("abc","pass1","abc@gmail.com","ROLE_NORMAL"));
        list.add(new User("xyz","pass2","xyz@gmail.com","ROLE_NORMAL"));
    }

    public List<User> getAllUsers() {
        return this.list;
    }

    public User getUser(String username) {
        return (User) this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
