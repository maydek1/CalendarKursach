package com.example.calendarkursach.repositories;

import com.example.calendarkursach.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public interface UserDBS extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
    User findUserById(Long id);
}
