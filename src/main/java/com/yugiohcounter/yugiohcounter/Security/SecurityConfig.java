package com.yugiohcounter.yugiohcounter.Security;


import com.yugiohcounter.yugiohcounter.Security.Filter.JwtAuthenticationFilter;
import com.yugiohcounter.yugiohcounter.Security.Filter.JwtValidationFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
     SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic(withDefaults()).authorizeHttpRequests(authz -> {
                    authz
                            /*.requestMatchers("/api/v1/cartas/cartaObjetivo/id/{id}").authenticated()
                            .requestMatchers("/api/v1/cartas/cartaObjetivo/name/{name}").hasAnyRole("ADMIN")
                            .requestMatchers("/api/v1/situacion/crear").hasAnyRole("USER","ADMIN")
                            .requestMatchers("/api/v1/users/registrar").authenticated()
                            .requestMatchers(HttpMethod.GET,"/api/v1/estrategia/id/{id}").permitAll()*/
                            .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                            .anyRequest().permitAll();
                })
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtValidationFilter(authenticationManager()))
                    .csrf(AbstractHttpConfigurer::disable)
                .cors(cors-> cors.configurationSource(corsConfigurationSource()))
                  .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration confi = new CorsConfiguration();
        confi.addAllowedOrigin("http://localhost:4200");
        confi.setAllowedOriginPatterns(Arrays.asList("*"));
        confi.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        confi.setAllowedHeaders(Arrays.asList("Authorization","Content-Type","Access-Control-Allow-Origin"));
        confi.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", confi);
        return source;
    }

   /* @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<>(
                new CorsFilter());
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;
    }*/
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
