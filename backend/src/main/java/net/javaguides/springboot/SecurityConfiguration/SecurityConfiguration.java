//package net.javaguides.springboot.SecurityConfiguration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.net.PasswordAuthentication;
//
//@EnableWebSecurity
//
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("role1")
//                .password("role1")
//                .roles("role1")
//                .and()
//                .withUser("role2")
//                .password("role2")
//                .roles("role2");
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/0**")
//                .hasRole("role1")
//                .antMatchers("/role2")
//                .hasRole("role2");
//
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordAuthorized(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
