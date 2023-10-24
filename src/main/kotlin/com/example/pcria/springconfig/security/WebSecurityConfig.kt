package com.example.pcria.springconfig.security

import com.example.pcria.common.jwt.JwtAccessDeniedHandler
import com.example.pcria.common.jwt.JwtAuthenticationEntryPoint
import com.example.pcria.common.jwt.JwtSecurityConfig
import com.example.pcria.common.jwt.TokenProvider
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.CorsFilter


@EnableWebSecurity
@EnableMethodSecurity
@Configuration
class WebSecurityConfig(
    private val tokenProvider: TokenProvider,
    private val corsFilter: CorsFilter,
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val jwtAccessDeniedHandler: JwtAccessDeniedHandler
) {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            // token을 사용하는 방식이기 때문에 csrf를 disable합니다.
            .csrf { it.disable() }

            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter::class.java)

            .exceptionHandling{
                it.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                  .accessDeniedHandler(jwtAccessDeniedHandler)
            }

            .authorizeHttpRequests{
                it.requestMatchers("/api/v1").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .anyRequest().authenticated()
            }

            // 세션을 사용하지 않기 때문에 STATELESS로 설정
            .sessionManagement{
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

            // enable h2-console
            .headers{
                it.frameOptions{ options ->
                    options.sameOrigin()
                }
            }

            .apply(JwtSecurityConfig(tokenProvider))
        return http.build()
    }
}