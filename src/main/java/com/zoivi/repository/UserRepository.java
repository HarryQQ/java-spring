package com.zoivi.repository;

import com.zoivi.domain.Girl;
import com.zoivi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qhr on 2017/5/17.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
