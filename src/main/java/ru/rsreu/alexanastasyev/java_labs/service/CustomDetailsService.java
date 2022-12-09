package ru.rsreu.alexanastasyev.java_labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rsreu.alexanastasyev.java_labs.model.CustomUser;
import ru.rsreu.alexanastasyev.java_labs.model.UserEntity;
import ru.rsreu.alexanastasyev.java_labs.repository.OAuthDao;

@Service
public class CustomDetailsService implements UserDetailsService {
    private OAuthDao oauthDao;

    @Autowired
    public CustomDetailsService(OAuthDao oauthDao) {
        this.oauthDao = oauthDao;
    }

    @Override
    public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity userEntity = null;
        try {
            userEntity = oauthDao.getUserDetails(username);
            CustomUser customUser = new CustomUser(userEntity);
            return customUser;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }
}
