package junia.lab04.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;
import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        // Users in memory.
        authManagerBuilder.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");

        // For User in database.
        authManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT login,password,enable FROM ingenieur WHERE login=?")
                .authoritiesByUsernameQuery("SELECT login,role FROM ingenieur WHERE login=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/list","/form","/list/**","/logout").hasAnyRole("USER")
        .and()
            .formLogin()
            .loginPage("/")
                .defaultSuccessUrl("/list")
                .failureUrl("/?error=true")
                .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/?logout=true")
            .invalidateHttpSession(true)
            .permitAll()
        .and()
            .csrf()
            .disable();
    }


}
