package controllers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.cors().and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/**").hasAuthority("ROLE_USER")
            .antMatchers("/**") .permitAll();
            // .anyRequest().authenticated()
            // .and()
            // .httpBasic();
    }

    @Autowired
    DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception {
            auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A))
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, hashedPassword, active from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users u, roles r, users_roles ur where u.id=ur.user_id and ur.roles_id=r.id and username=?");
        
    }
            
}
