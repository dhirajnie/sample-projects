package com.security.demo.configuration;

public class AccessToken
{
    String token;


    public AccessToken( String token )
    {
        this.token = token;
    }


    @Override
    public String toString()
    {
        return "AccessToken{" + "token='" + token + '\'' + '}';
    }
}
