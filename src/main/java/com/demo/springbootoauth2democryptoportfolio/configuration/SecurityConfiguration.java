package com.demo.springbootoauth2democryptoportfolio.configuration;

import com.demo.springbootoauth2democryptoportfolio.enums.RoleEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/support/admin").hasRole(RoleEnum.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin(form -> form.loginPage("/login"));

        return http.build();
    }

    @Bean
    WebSecurityCustomizer defaultWebSecurityCustomizer() {
        return (WebSecurity web) -> web.ignoring().requestMatchers("/css/**");
    }
}
