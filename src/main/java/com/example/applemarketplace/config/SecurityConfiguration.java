package com.example.applemarketplace.config;
import com.example.applemarketplace.model.enums.Role;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/user/login", "/user/register", "/user/login-error",
                                "/about-us", "contact-us/**","/error").permitAll()
                        .requestMatchers("/home","/devices/**","/iPhones/**","/macBooks/**", "/watches/**",
                                "/comments/**","/user/**").hasRole(Role.USER.name())
                        .requestMatchers("/**").hasRole(Role.ADMIN.name())
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin
                            .loginPage("/user/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/home")
                            .failureForwardUrl("/user/login-error");
                }
        ).logout(
                logout -> {
                    logout
                            .logoutUrl("/user/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID");
                }
        ).build();
    }
}
