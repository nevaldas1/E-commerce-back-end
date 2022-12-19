package com.evaldas.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    //Configuration class, that defines, who need to be authenticated
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //Protect endpoint
        http.authorizeRequests(configurer ->
                        configurer
                                //Make endpoints accessible only to authenticated users.
                                .antMatchers("/api/orders/**")
                                .authenticated())
                //Configures ourselves as OAuth2, adds support
                .oauth2ResourceServer()
                //Enables JWT (JSON Web Token) encoded bearer token support
                .jwt();

        //Add cors filters
        http.cors();

        //Add content negotiation strategy to support Okta sending back response 401
        //Handles information based on information in header
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        //Force a non-empty response body for 401
        Okta.configureResourceServer401ResponseBody(http);

        //Disable CSRF since cookies are not being used for session tracking
        http.csrf().disable();

        return http.build();
    }

}
