//package com.security.demo.service;
//
//import com.security.demo.entities.User;
//import com.security.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//
//public class CustomUserDetailService implements UserDetailsService
//{
//    @Autowired private UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername( String userName ) throws UsernameNotFoundException
//    {
//        System.out.println("here");
//        Optional<User> users = Optional.ofNullable( userRepository.findByName( userName ) );
//        return null;
//
//    }
//
//
//}
