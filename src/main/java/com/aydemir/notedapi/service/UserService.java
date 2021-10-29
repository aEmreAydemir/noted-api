package com.aydemir.notedapi.service;

import com.aydemir.notedapi.dto.User;
import com.aydemir.notedapi.model.UserInfo;
import com.aydemir.notedapi.repository.UserRepository;
import com.aydemir.notedapi.utils.JwtUtil;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;

    public void create(User user) {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        User dummy = userRepository.save(user);
       // log.info(userRepository.getByEmail(dummy.getEmail()).getEmail()+"sadasd");

    }

    public UserInfo authenticate(String email, String password) throws Exception {
        User user = userRepository.getByEmail(email);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials", e);
        }
            UserDetails userDetails = loadUserByUsername(email);

            UserInfo info = new UserInfo();
            info.setId(user.getId());
            info.setEmail(user.getEmail());
            info.setName(user.getName());
            info.setToken(jwtUtil.generateToken(userDetails)); //TODO
            return info;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(s);
        if (user !=  null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
        }
        return null;
    }
}
