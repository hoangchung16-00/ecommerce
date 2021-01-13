package com.example.eCommerce.services;

import com.example.eCommerce.models.User;
import com.example.eCommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public boolean isCredential(final String username,String password,final boolean isAdmin){
        final User user = userRepository.getUserByUsername(username);
        if(user==null){
            return false;
        }
        return user.getPassword().equals(password) && user.isAmin()==isAdmin;
    }
    @Transactional
    public User getUserByUserName(final String username){
        return userRepository.getUserByUsername(username);
    }
}
