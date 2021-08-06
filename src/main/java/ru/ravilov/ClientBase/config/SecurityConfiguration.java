package ru.ravilov.ClientBase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.ravilov.ClientBase.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return  auth;
    }
   @Override
   protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
   }

   @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/edit/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/delete/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/showUserList").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/showUserList/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/deleteUser/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newCarCategory").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newCar").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newModifyAuto").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newModifyMoto").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newModifyTruck").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newMotoCategory").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newMoto").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newTruckCategory").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newTruck").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newSegment").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/newGeneration").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/**").permitAll()
                .antMatchers(
                "/registration**",
                        "/static/js/**",
               "/css/**",
               "/img/**"
        )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
   }
}
