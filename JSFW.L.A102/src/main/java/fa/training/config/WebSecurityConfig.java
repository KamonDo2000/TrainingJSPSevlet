package fa.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Class Config web security
 * @author VuPH7
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	// Declare UserDetailsService 
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * function bcrypt encode password  
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * function provide authenrity to user
	 * @return auProvider
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auProvider = new DaoAuthenticationProvider();
		auProvider.setUserDetailsService(userDetailsService);
		auProvider.setPasswordEncoder(passwordEncoder());
		return auProvider;
	}
	
	/**
	 * function configure
	 * @param auth
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
	}
	
	/**
	 * function http config
	 * @param http
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/AboutPage").permitAll()
		.antMatchers("/LoginPage").permitAll()
		.antMatchers("/ContactPage").hasAnyRole("ADMIN","USER")
		.antMatchers("/ManagePostPage").hasAnyRole("ADMIN","USER")
		.antMatchers("/CreatePostPage").hasAnyRole("ADMIN","USER")
		.antMatchers("/ManageCommentPage/**").hasAnyRole("ADMIN","USER")
		.antMatchers("/ManageCommentPage").hasAnyRole("ADMIN","USER")
		.antMatchers("/EditPostPage").hasAnyRole("ADMIN","USER")
		.and()
		.formLogin().loginPage("/LoginPage")
		.usernameParameter("username").passwordParameter("password")
		.loginProcessingUrl("/doLogin")
		.successForwardUrl("/postLogin")
		.failureUrl("/loginFailed").and().logout().logoutUrl("/doLogout")
		.logoutSuccessUrl("/logout").permitAll()
		.and().csrf().disable();
	}
}
