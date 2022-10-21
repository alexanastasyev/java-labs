package ru.rsreu.alexanastasyev.java_labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rsreu.alexanastasyev.java_labs.model.User;
import ru.rsreu.alexanastasyev.java_labs.repository.UserRepository;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByUsername(username));
        return user.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

}
