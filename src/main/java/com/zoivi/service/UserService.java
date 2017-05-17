package com.zoivi.service;

import com.zoivi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qhr on 2017/5/17.
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
