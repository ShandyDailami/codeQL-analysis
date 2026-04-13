package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableWebSecurity
public class java_30920_SessionManager_A01 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(sessionManagementFilter(), SessionManagementFilter.class);
    }

    private SessionManagementFilter sessionManagementFilter() {
        SessionManagementFilter sessionManagementFilter = new SessionManagementFilter();
        sessionManagementFilter.setSessionStrategy(new HttpSessionStrategy());
        sessionManagementFilter.setMaximumSessions(1);
        sessionManagementFilter.setExceptionIfSessionNotFound(true);
        return sessionManagementFilter;
    }
}