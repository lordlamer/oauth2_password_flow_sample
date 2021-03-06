package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author straubec
 */
@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user01")
                    .password("password")
                    .authorities("USER", "RESOURCE_001_HELLO").and()
                .withUser("user02")
                    .password("password")
                    .authorities("USER", "RESOURCE_001_HELLO", "RESOURCE_002_HELLO").and()
                .withUser("admin")
                    .password("admin")
                    .authorities("USER", "ADMIN", "RESOURCE_001_HELLO", "RESOURCE_002_HELLO");
    }    
    
}
