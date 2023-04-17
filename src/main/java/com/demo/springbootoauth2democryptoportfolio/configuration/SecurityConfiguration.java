package com.demo.springbootoauth2democryptoportfolio.configuration;

import com.demo.springbootoauth2democryptoportfolio.enums.RoleEnum;
import com.demo.springbootoauth2democryptoportfolio.handlers.AuthenticationSuccessHandlerImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(100)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .mvcMatchers("/login", "css/**","/favicon.ico").permitAll()
                .mvcMatchers("/support/admin").hasRole(RoleEnum.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .successHandler(new AuthenticationSuccessHandlerImpl())
//                    .defaultSuccessUrl("/home")
                .and()
                .logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("u")
                .password(passwordEncoder.encode("1"))
                .roles(RoleEnum.USER.name());
        auth.inMemoryAuthentication()
                .withUser("a")
                .password(passwordEncoder.encode("1"))
                .roles(RoleEnum.ADMIN.name());
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().mvcMatchers("/css/**"); // Not recommended by Spring Security
//    }
}
