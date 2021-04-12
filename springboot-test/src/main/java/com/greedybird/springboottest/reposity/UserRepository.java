package com.greedybird.springboottest.reposity;

import com.greedybird.springboottest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByUsernameAndPassword(String name, String password);
}
