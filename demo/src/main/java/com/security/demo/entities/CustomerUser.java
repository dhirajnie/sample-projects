package com.security.demo.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


public class CustomerUser extends User
{

    String userName;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private boolean active;
    private Set<Role> roles;


    public CustomerUser( String userName, String email, String password, String name, String lastName, boolean active,
        Collection<? extends GrantedAuthority> authorities )
    {
        super( userName, password, true, true, true, true, authorities );
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.active = active;
    }


}



