package com.example.server_exam.config

import com.example.server_exam.jwt.JwtFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var jwtFilter: JwtFilter

    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
            .antMatchers("/login")
            .permitAll()
            .anyRequest()
            .authenticated()
        http!!.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}