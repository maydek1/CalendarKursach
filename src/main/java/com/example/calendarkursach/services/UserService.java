package com.example.calendarkursach.services;

import com.example.calendarkursach.models.Role;
import com.example.calendarkursach.models.User;
import com.example.calendarkursach.repositories.UserDBS;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDBS userDbs;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDbs.findUserByLogin(login);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }

    public boolean saveUser(User user) {
        User userFromDB = userDbs.findUserByLogin(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        System.out.println(user);
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDbs.save(user);
        return true;
    }
}
