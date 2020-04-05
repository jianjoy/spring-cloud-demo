package com.example.demo;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfToken;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ReaderRepository readerRepository;
//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").access("hasRole('READER')").and()
				.formLogin()
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						System.out.println("success");
						response.sendRedirect("sa/"+request.getParameter("username"));
//						request.getRequestDispatcher("/sa/"+request.getParameter("username")).forward(request, response);
					}
				})
//				.failureHandler(new AuthenticationFailureHandler() {
////					@Override
////					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
////							AuthenticationException exception) throws IOException, ServletException {
////						System.out.println("验证失败");
////						request.getRequestDispatcher("/login").forward(request, response);
////					}
////				})
				.failureForwardUrl("/login?error=true");
		

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").antMatchers("/static/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider p = new DaoAuthenticationProvider();
		p.setUserDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Optional<Reader> optional = readerRepository.findById(username);
				if (!optional.isPresent()) {
					System.out.println("用户不存在");
					throw new UsernameNotFoundException("用户不存在");
				}
				return optional.get();
			}
		});
		p.setPasswordEncoder(new PasswordEncoder() {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.toString().equals(encodedPassword);
			}

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		});
		auth.authenticationProvider(p);
		
//		UserDetailsService us = new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				Optional<Reader> optional = readerRepository.findById(username);
//				if (!optional.isPresent()) {
//					throw new UsernameNotFoundException("用户不存在");
//				}
//				return optional.get();
//			}
//		};
//		DaoAuthenticationProvider p = new DaoAuthenticationProvider();
//		p.setPasswordEncoder(new PasswordEncoder() {
//			@Override
//			public boolean matches(CharSequence rawPassword, String encodedPassword) {
//				return rawPassword.toString().equals(encodedPassword);
//			}
//
//			@Override
//			public String encode(CharSequence rawPassword) {
//				return rawPassword.toString();
//			}
//		});
//		p.setUserDetailsService(us);
//		auth.authenticationProvider(p);
//		auth.userDetailsService(us);
	}

}
