package com.zoivi.repository;

import com.zoivi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by qhr on 2017/5/17.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByUsername (String username);
}
