package com.lis.exam.config;
//package com.lis.exam;
//
//import org.keycloak.adapters.KeycloakConfigResolver;
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
//import org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
//@KeycloakConfiguration
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
//	
//    @Bean
//    public FilterRegistrationBean keycloakAuthenticationProcessingFilterRegistrationBean(
//            KeycloakAuthenticationProcessingFilter filter) {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
//        registrationBean.setEnabled(false);
//        return registrationBean;
//    }
//    
//    @Bean
//    public FilterRegistrationBean keycloakPreAuthActionsFilterRegistrationBean(
//            KeycloakPreAuthActionsFilter filter) {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
//        registrationBean.setEnabled(false);
//        return registrationBean;
//    }
//	
//    /**
//     * Registers the KeycloakAuthenticationProvider with the authentication manager.
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    	KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//    	keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//	/**
//	 * Defines the session authentication strategy
//	 */
//    @Bean
//	@Override
//	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//    	/**
//    	 * provide a session authentication strategy bean which should be of type 
//    	 * RegisterSessionAuthenticationStrategy for public or confidential applications and 
//    	 * NullAuthenticatedSessionStrategy for bearer-only applications.
//    	 */
//		// for public/confidential: return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    	return new NullAuthenticatedSessionStrategy();
//	}
//	
//	@Bean
//	public KeycloakConfigResolver keycloakConfigResolver() {
//		return new KeycloakSpringBootConfigResolver();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
//		// disable csrf in header, to allow post data in header as spring blocks by default
//		// need to search for alternative solution
//		http.csrf().disable();
//		http
//        .authorizeRequests()
//        .antMatchers("/api/*").hasRole("user")
//        .anyRequest().permitAll();
//	}
//
//}
//
