package com.demo.springbootoauth2democryptoportfolio.configuration;

import com.demo.springbootoauth2democryptoportfolio.enums.RoleEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(99)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.mvcMatcher("/support/admin")
                .authorizeRequests().anyRequest().hasRole(RoleEnum.ADMIN.name())
                .and()
                .formLogin(form -> form.loginPage("/login"));
    }
}
