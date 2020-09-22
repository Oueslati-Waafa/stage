package com.stage.backend.stage.services;

import com.stage.backend.stage.Repository.UserRepository;
import com.stage.backend.stage.models.MyUserDetails;
import com.stage.backend.stage.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// C'est un spring service
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired

    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(()-> new UsernameNotFoundException("Not Found : " + userName));
        return user.map(MyUserDetails::new).get();
    }
}