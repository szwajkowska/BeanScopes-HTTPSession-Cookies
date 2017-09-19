package pl.ania.notes.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable();
        security.httpBasic().disable();
//        security
//                .authorizeRequests()
//                .antMatchers("/", "/test/signIn", "/users", "/test/login", "/test").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/test/login").permitAll()
//                .and()
//                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user1").password("1").roles("USER");
//        auth
//                .inMemoryAuthentication()
//                .withUser("user2").password("2").roles("USER");
        auth.authenticationProvider(authProvider);

    }
}


