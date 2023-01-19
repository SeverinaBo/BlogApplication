package com.severina.BlogApp.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {


    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
 /*       http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/products")
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .permitAll();*/
    }
}
