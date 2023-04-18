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
        // Do not disable the security headers in production
        http
                .cors().disable() // Adds csrf token known only to specific website, without this request gets rejected
                .headers()
                    .cacheControl().disable() // Cache-Control: no-cache, no-store, max-age=0, must-revalidate
                    .xssProtection().disable() // X-XSS-Protection: 1; mode=block
                    .contentTypeOptions().disable() // X-Content-Type-Options: nosniff
                .and()
                .authorizeHttpRequests()
                    .mvcMatchers("/login", "css/**","/favicon.ico").permitAll()
                    .mvcMatchers("/support/admin").hasRole(RoleEnum.ADMIN.name())
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .successHandler(new AuthenticationSuccessHandlerImpl())
                    .defaultSuccessUrl("/")
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
