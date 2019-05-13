package com.security.demo.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class CustomUserDetails extends User implements UserDetails
{


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }


    @Override
    public String getPassword()
    {
        return super.getPassword();
    }


    @Override
    public String getUsername()
    {
        return super.getName();
    }


    @Override
    public boolean isAccountNonExpired()
    {
        return false;
    }


    @Override
    public boolean isAccountNonLocked()
    {
        return false;
    }


    @Override
    public boolean isCredentialsNonExpired()
    {
        return false;
    }


    @Override
    public boolean isEnabled()
    {
        return false;
    }
}