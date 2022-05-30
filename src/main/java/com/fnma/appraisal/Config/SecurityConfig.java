package com.fnma.appraisal.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
public class SecurityConfig {

    @Bean
    public  InMemoryUserDetailsManager configureAuthentication(){

        List<UserDetails> userDetails = new ArrayList<>();
        List<GrantedAuthority> bankAuthorities = new ArrayList<>();
        bankAuthorities.add(new SimpleGrantedAuthority("ROLE_BANK"));
        List<GrantedAuthority> appraiserAuthorities = new ArrayList<>();
        appraiserAuthorities.add(new SimpleGrantedAuthority("ROLE_APPRAISER"));
        userDetails.add(new User("bank","$2a$10$Uy.pNTdTjOV7aS6AmY493O/SgIVPhIqmgrWfvcYy1g/903H.pzmAy", bankAuthorities));
        userDetails.add(new User("appraiser","$2a$10$Uy.pNTdTjOV7aS6AmY493O/SgIVPhIqmgrWfvcYy1g/903H.pzmAy", appraiserAuthorities));
        return new InMemoryUserDetailsManager(userDetails);
    }
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("appraisals/post/*").hasAuthority("ROLE_APPRAISER")
                .antMatchers("appraisals/*").permitAll()
                .antMatchers("propertys/*").permitAll()
                .and().formLogin();
        return  http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder(10);
    }
}