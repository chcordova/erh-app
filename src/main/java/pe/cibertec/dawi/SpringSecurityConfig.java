package pe.cibertec.dawi;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

/*    @Autowired
    private LoginSuccessHandler successHandler;*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/persona/**").hasAnyRole("ADMINISTRADOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.successHandler(successHandler)
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Administrador").password("12345").roles("ADMINISTRADOR")
                .and()
                .withUser("Director").password("12345").roles("DIRECTOR")
                .and()
                .withUser("Master").password("12345").roles("MASTER")
                .and()
                .withUser("Medico").password("12345").roles("MEDICO")
                .and()
                .withUser("Paciente").password("12345").roles("PACIENTE");
    }

}
