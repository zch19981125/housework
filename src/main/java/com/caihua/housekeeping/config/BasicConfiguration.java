//package com.caihua.housekeeping.config;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.caihua.housekeeping.entity.User;
//import com.caihua.housekeeping.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class BasicConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	UserMapper userMapper;
//
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				User user= userMapper.selectByUsername(username);
//				List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
//				grantedAuthorities.add(new GrantedAuthority() {
//					@Override
//					public String getAuthority() {
//						return "Role_user";
//					}
//				});
//				return new org.springframework.security.core.userdetails.User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),grantedAuthorities);
//			}
//		}).passwordEncoder(new BCryptPasswordEncoder());
//	}
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests().anyRequest().permitAll();
////		http.formLogin();
////		http.logout();
//		http.authorizeRequests()
//			.antMatchers("/**").permitAll()
//			.anyRequest().authenticated();
//	}
//}
