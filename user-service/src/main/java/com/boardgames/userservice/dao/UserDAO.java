package com.boardgames.userservice.dao;

import com.boardgames.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {
    Optional<User> findByIdAndActiveTrue(Integer userId);
}
