package com.book.store.Config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class DemoSecurity extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userService;

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication().withUser(users.username("user").password("password").roles("USER"));
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }


    protected void configure(HttpSecurity http) throws Exception { // config security of web paths in app , login ,logout.etc
        http.authorizeRequests().// Restrict acces on the httpservletRequest
                anyRequest().//Any request to the app must be Authenticated (ie logged in)
                authenticated()
                .and()
                .formLogin()// custom login form
                // .loginPage("/showLoginPage") // show login form page
                //  .loginProcessingUrl("/authenticateTheUser") //login form sbould post the data to this url{check user id nd password}
                .permitAll()// allows everyone to see login page
                .and()
                .logout().permitAll();

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
