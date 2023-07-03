package it.uniba.dib.mfs.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login", "/").permitAll()
		.antMatchers("/moderatorPage", "/moderatorPage/**","/listSystemFeedbackMod",
				"/profilePage", "/updateProfile", "/FeedbackNewsMod")
		.access("hasRole ('MOD')")
		.and()
		.formLogin(form -> form
				.loginPage("/login")
				.permitAll())

		.logout()
		.logoutSuccessUrl("/");
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT email_string , password_string, true FROM moderators WHERE email_string = ?")
		.authoritiesByUsernameQuery("SELECT email_string, 'ROLE_MOD' FROM moderators WHERE email_string = ?")
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
