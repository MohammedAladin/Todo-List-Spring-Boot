package com.SpringBoot.Course.springnoot.security;



import com.SpringBoot.Course.springnoot.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user =  userRepository.findByEmail(email);
        if(user == null){
            throw new NotFoundException("User is not exist in DataBase.... ");
        }
        return user;

        //return new User("Mohammed", passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
    }

    public List<AppUser> getAll(){

        return userRepository.findAll();
    }

    public AppUser AddUser(AppUser user){
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.insert(user);
    }

    public AppUser getUserById(String id){
        return userRepository.findById(id).get();
    }

}
