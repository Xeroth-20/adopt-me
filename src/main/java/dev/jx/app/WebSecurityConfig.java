package dev.jx.app;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/pets").authenticated()
                .regexMatchers("/pets/[0-9]+$").authenticated()
                .antMatchers("/pets/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/animals").authenticated()
                .antMatchers("/animals/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/areas").authenticated()
                .antMatchers("/areas/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/areas-animals").authenticated()
                .regexMatchers("/areas-animals/[0-9]+$").authenticated()
                .antMatchers("/area-animals/**", "/areas-animals/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/medical-records").authenticated()
                .antMatchers("/medical-records/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/dosages").authenticated()
                .regexMatchers("/dosages/[0-9]+$").authenticated()
                .antMatchers("/dosages/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/vaccines").authenticated()
                .antMatchers("/vaccines/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/owners").authenticated()
                .antMatchers("/owners/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/adoptions").authenticated()
                .antMatchers("/adoptions/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/images").authenticated()
                .antMatchers("/images/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/users/**").hasAnyAuthority("ADMIN")
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error=true")
                .and().logout();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
