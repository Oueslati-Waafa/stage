package com.stage.backend.stage.services;

import com.stage.backend.stage.Repository.UserRepository;
import com.stage.backend.stage.models.MyUserDetails;
import com.stage.backend.stage.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByUserName(name);
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User removed !! " + id;
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setRole(user.getRole());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setActive(user.getActive());
        return userRepository.save(existingUser);
    }

}