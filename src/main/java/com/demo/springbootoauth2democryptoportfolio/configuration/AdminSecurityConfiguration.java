//package com.demo.springbootoauth2democryptoportfolio.configuration;

//import com.demo.springbootoauth2democryptoportfolio.enums.RoleEnum;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@Order(99)
//public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.mvcMatcher("/support/admin")
//                .authorizeRequests()
//                .anyRequest()
//                .hasRole(RoleEnum.ADMIN.name())
//                .and()
//                .formLogin()
//                .and()
//                .logout();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        authenticationManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder.encode("password1"))
//                .roles(RoleEnum.ADMIN.name());
//    }
//}
