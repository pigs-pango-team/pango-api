package com.gg_pigs.user.repository;

import com.gg_pigs.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Long countByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
