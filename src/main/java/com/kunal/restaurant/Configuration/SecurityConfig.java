/*
 * package com.kunal.restaurant.Configuration;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.actuate.autoconfigure.observation.
 * ObservationProperties.Http; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationProvider; import
 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 * import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import org.springframework.security.core.userdetails.User;
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager;
 * 
 * import com.kunal.restaurant.Entity.UserSaveEntity;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig {
 * 
 * @Autowired UserDetailsService userDetailsService;
 * 
 * 
 * @Bean public AuthenticationProvider authenticationProvider() {
 * DaoAuthenticationProvider daoAuthenticationProvider = new
 * DaoAuthenticationProvider();
 * daoAuthenticationProvider.setUserDetailsService(userDetailsService);
 * daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance(
 * )); return daoAuthenticationProvider; }
 * 
 * 
 * 
 * @Bean public UserDetailsService userDetailsService(PasswordEncoder encoder) {
 * UserDetails admin = User.withUsername("Kunal")
 * .password(encoder.encode("Pass@321")) .roles("Admin").build(); UserDetails
 * user = User.withUsername("Karan") .password(encoder.encode("Pass@789"))
 * .roles("User").build(); return new InMemoryUserDetailsManager(admin,user);
 * 
 * }
 * 
 * 
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * }
 */