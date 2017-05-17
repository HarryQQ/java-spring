package com.zoivi.service;

import com.zoivi.domain.User;
import com.zoivi.enums.ResultEnums;
import com.zoivi.exception.UserException;
import com.zoivi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qhr on 2017/5/17.
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findByUsername  (String username) throws Exception {
        List<User> userList = userRepository.findByUsername(username);
        if (userList.size() <= 0) {
           throw new UserException(ResultEnums.USER_NO_FOUND);
        }
        return userList.get(0);
    };
}
