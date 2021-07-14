package eterrapn.security;

//import eterrapn.jpa.Pn_radnik;
//import eterrapn.reps.PnRadnikRepository;
import net.sf.jasperreports.data.http.RequestMethod;

import java.security.Principal;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//class EterrapnSecurityConfiguration<GrantedAuthority> extends WebSecurityConfigurerAdapter {

	
	/*
	@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        // ...
	        http.cors();
	    }
	
	*/
	
	/*
	@Autowired
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
	

	
	
	
	@CrossOrigin
	@Bean
	protected
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			//	Pn_radnik pn_radnik = pnRadnikRepository.findByUsername(username);
				     	

					PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

					return new User("BAR", encoder.encode("FhPX4Aymt3TypWkD") , true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_ADMINISTRATOR"));
			}
		};
	}
	
	
	

	@GetMapping("/logout")
	public void exit(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, null, null);
        try {
              response.sendRedirect(request.getHeader("http://localhost:8083"));
              } catch (Exception e) {
          //  e.printStackTrace();

        }
    }
	
	
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
		
		 
		 http.cors();
		 
		 
		  http.
		  authorizeRequests().antMatchers("/tipobveznika**").access("hasRole('ADMINISTRATOR')")
		  .and().authorizeRequests().antMatchers("/obveznik/**").access("hasRole('ADMINISTRATOR')")
		  .and().authorizeRequests().antMatchers("/zaduzenjezemsum/**").access("hasRole('ADMINISTRATOR')")
		  .and().authorizeRequests().antMatchers("/tipzaduzenja**").access("hasRole('ADMINISTRATORR')")

		  .and().formLogin().permitAll();
	    
		  
		  
		  // some more method calls
	     
	  
	  }
	 
	 
	 
	*/
	  

	
//}