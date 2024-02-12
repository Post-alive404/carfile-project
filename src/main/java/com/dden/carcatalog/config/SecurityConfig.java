package com.dden.carcatalog.config;

import com.dden.carcatalog.filter.AuthenticationFilter;
import com.dden.carcatalog.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SecurityConfig
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.builder().username("user")
//                .password(passwordEncoder().encode("pas"))
//                .roles("USER").build();
//
//        return new  InMemoryUserDetailsManager(user);
//    }
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationFilter authenticationFilter;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, AuthenticationFilter authenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.authenticationFilter = authenticationFilter;
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManager) -> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST, "/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
