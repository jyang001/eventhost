package com.yang.eventhost.security;

import com.yang.eventhost.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Configuration
/* defines more 'bean' methods
 * want to create beans to configure our security around our app
 */

/**
 * Spring Security: manages authentication, password encryption and configuration
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/javax.faces.resource/**");
	}

	/**
	 * Crates bean of 'BCryptPasswordEncoder' to use to encrypt passwords
	 * @return BCryptPasswordEncoder object
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	//TODO:create own security (determine which webpages can be accessed by public and which can't)

	/**
	 * determines which routes can be accessed and also manages login
	 */
		@Override
		protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/resources/**","/css/**","/js/**","/img/**","/static/**","/webjars/**","/","/user/signup","/user/login").permitAll();

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().anyRequest().authenticated().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/user/login")//
				.defaultSuccessUrl("/")//
				.failureUrl("/user/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")
				// Config for Logout Page
				.and().logout().logoutUrl("/user/logout").logoutSuccessUrl("/");
    }

}
