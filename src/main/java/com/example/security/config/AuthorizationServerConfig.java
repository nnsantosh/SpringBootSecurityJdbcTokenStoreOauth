package com.example.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.example.security.service.CustomUserDetailsServiceImpl;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	static final String CLIEN_ID = "sampleClientId";
	static final String CLIENT_SECRET = "secret";
	static final String GRANT_TYPE_PASSWORD = "password";
	static final String AUTHORIZATION_CODE = "authorization_code";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String IMPLICIT = "implicit";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String TRUST = "trust";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
	static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;
	static final String RESOURCE_ID = "resource_id";
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailsServiceImpl customUserDetailsService;


	@Override
	public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
		.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
				.passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		/*
		 * configurer.inMemory().withClient(CLIEN_ID).secret(passwordEncoder.encode(
		 * CLIENT_SECRET)) //.authorizedGrantTypes(GRANT_TYPE_PASSWORD,
		 * AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT)
		 * .authorizedGrantTypes(AUTHORIZATION_CODE,REFRESH_TOKEN)
		 * .scopes("user_info").accessTokenValiditySeconds(
		 * ACCESS_TOKEN_VALIDITY_SECONDS) .autoApprove(true)
		 * .refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS).resourceIds(
		 * RESOURCE_ID) //.redirectUris("http://localhost:8081/api/v1/client/hello");
		 * .redirectUris("http://localhost:8081/login");
		 */
		
		configurer.jdbc(dataSource);
	}
	
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		
		endpoints
		.authenticationManager(this.authenticationManager)
		//.accessTokenConverter(accessTokenConverter())
		.tokenStore(tokenStore)
		.userDetailsService(customUserDetailsService);
		
		
	}
	
	
	

}
