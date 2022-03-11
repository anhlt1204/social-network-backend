package com.ados.socialnetwork.service;

import com.ados.socialnetwork.domain.request.RegisterRequest;
import com.ados.socialnetwork.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles;

        com.ados.socialnetwork.domain.entity.User user = userRepo.findByEmail(email);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new User(user.getEmail(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the email " + email);
    }

    public com.ados.socialnetwork.domain.entity.User save(RegisterRequest request) {
        com.ados.socialnetwork.domain.entity.User user = new com.ados.socialnetwork.domain.entity.User();
        user.setEmail(request.getEmail());
        user.setPassword(bcryptEncoder.encode(request.getPassword()));
        user.setRole("USER");
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setCreateBy(request.getEmail());
        user.setBirthday(request.getBirthday());

        return userRepo.save(user);
    }
}
