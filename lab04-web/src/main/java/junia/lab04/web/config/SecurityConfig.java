package junia.lab04.web.config;

import junia.lab04.core.entity.Ingenieur;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //MyDBAuthenticationService myDBAauthenticationService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Users in memory.
        auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");

        // For User in database.
        //auth.userDetailsService(myDBAauthenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/")
            .permitAll()
        .antMatchers("/**")
            .hasAnyRole("USER")
        .and()
            .formLogin()
            .loginPage("/")
                .defaultSuccessUrl("/list")
                .failureUrl("/?error=true")
                .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .permitAll()
        .and()
            .csrf()
            .disable();
    }


}
