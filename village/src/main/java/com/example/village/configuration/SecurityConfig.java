package com.example.village.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;



    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
//                .anyRequest().authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/adminView").hasRole("ADMIN")
                .antMatchers("/adminCustomer").hasRole("ADMIN")
                .antMatchers("/adminMessage").hasRole("ADMIN")
                .antMatchers("/adminProduct").hasRole("ADMIN")
                .antMatchers("/adminOrders").hasRole("ADMIN")
                .antMatchers("/adminSubProduct").hasRole("ADMIN")
                .antMatchers("/adminStore").hasRole("ADMIN")
                .antMatchers("/userDashboard").hasAnyRole("ADMIN","USER")
                .antMatchers("/userMessage").hasAnyRole("ADMIN","USER")
                .antMatchers("/userTable").hasAnyRole("ADMIN","USER")
                .antMatchers("/userView").hasAnyRole("ADMIN","USER")
                .antMatchers("/userBalance").hasAnyRole("ADMIN","USER")
                .antMatchers("/register").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/forgetPass").permitAll()
//                .anyRequest().permitAll()
                .and().httpBasic()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .successHandler(new CustomAuthenticationSuccessHandler())
                .and()
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select email,password,1 from village.customer where email=?")
                .authoritiesByUsernameQuery("select  customer_email,name from village.role where customer_email=?");
      }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**","/static/**","**/css/**","**/js/**","**/img/**");
    }
}
