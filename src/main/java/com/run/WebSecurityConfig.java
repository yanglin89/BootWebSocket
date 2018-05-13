package com.run;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/login").permitAll() //设置spring security对 / 和 /login 路径不拦截
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login") //设置spring security登陆页面访问路径为/login
			.defaultSuccessUrl("/chat") //登陆成功后跳转到 /chat路径
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("yl").password("yl").roles("USER")
			.and()
			.withUser("lhy").password("lhy").roles("USER"); //在内存中设置两个用户
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/static/**"); ///resources/static/ 目录下的静态资源，spring security不拦截
	}
	
	
	
	
	
	

}
