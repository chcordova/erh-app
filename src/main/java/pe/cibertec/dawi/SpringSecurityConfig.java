package pe.cibertec.dawi;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                //.anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Administrador").password("{noop}12345").roles("ADMINISTRADOR")
                .and()
                .withUser("Director").password("{noop}12345").roles("DIRECTOR")
                .and()
                .withUser("Master").password("{noop}12345").roles("MASTER")
                .and()
                .withUser("Medico").password("{noop}12345").roles("MEDICO")
                .and()
                .withUser("Paciente").password("{noop}12345").roles("PACIENTE");
    }

}
