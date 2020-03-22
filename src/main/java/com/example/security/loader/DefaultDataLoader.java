
package com.example.security.loader;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.security.domain.AuthRoles;
import com.example.security.domain.AuthUserRoles;
import com.example.security.domain.AuthUsers;
import com.example.security.domain.OauthAccessToken;
import com.example.security.domain.OauthClientDetails;
import com.example.security.domain.OauthRefreshToken;
import com.example.security.repository.AuthRolesRepository;
import com.example.security.repository.AuthUserRolesRepository;
import com.example.security.repository.AuthUsersRepository;
import com.example.security.repository.OauthAccessTokenRepository;
import com.example.security.repository.OauthClientDetailsRepository;
import com.example.security.repository.OauthRefreshTokenRepository;

@Component
public class DefaultDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AuthUsersRepository authUsersRepository;

	@Autowired
	private AuthRolesRepository authRolesRepository;

	@Autowired
	private AuthUserRolesRepository authUserRolesRepository;

	@Autowired
	private OauthClientDetailsRepository oauthClientDetailsRepository;
	
	@Autowired
	private OauthAccessTokenRepository oauthAccessTokenRepository;
	
	@Autowired
	private OauthRefreshTokenRepository oauthRefreshTokenRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent cse) {
		System.out.println("Handling context re-freshed event. ");

		if (authUsersRepository.count() == 0) {
			Date currentDate = new Date();
			AuthUsers user1 = new AuthUsers(1, "admin", "admin", "admin",
					"$2a$10$6tkeClSwZh5itN6Con4vkug4Liv7MK8TSCGuIlVpmTNNpcDYh3/hq", "admin@example.com", true,
					currentDate, currentDate);
			AuthUsers user2 = new AuthUsers(2, "test", "test", "test",
					"$2a$10$MRJ5LM6lUN8L/gtQz.TqIegZDKQAngXWSBLWvNh/wPC2Nm0ZCf.uC", "test@example.com", true,
					currentDate, currentDate);
			authUsersRepository.save(user1);
			authUsersRepository.save(user2);
			System.out.println("DefaultDataLoader.onApplicationEvent() created some users");
		}

		if (authRolesRepository.count() == 0) {
			Date currentDate1 = new Date();
			AuthRoles role1 = new AuthRoles(3, "ADMIN", currentDate1, currentDate1);
			AuthRoles role2 = new AuthRoles(4, "ANALYST", currentDate1, currentDate1);
			authRolesRepository.save(role1);
			authRolesRepository.save(role2);
			System.out.println("DefaultDataLoader.onApplicationEvent() created some roles");
		}

		if (authUserRolesRepository.count() == 0) {
			Date currentDate2 = new Date();
			AuthUserRoles userRole1 = new AuthUserRoles(5, 1, 3, currentDate2, currentDate2);
			AuthUserRoles userRole2 = new AuthUserRoles(6, 2, 4, currentDate2, currentDate2);
			authUserRolesRepository.save(userRole1);
			authUserRolesRepository.save(userRole2);
			System.out.println("DefaultDataLoader.onApplicationEvent() assigned roles to users");
		}

		if (oauthClientDetailsRepository.count() == 0) {
			OauthClientDetails oauthClientDetails = new OauthClientDetails("sampleClientId", "resource_id", "$2a$10$auDwTW35Pdcs8.ni2OBImu3.q3VTgsp4s0cRCgCj9omLFFVMovxoO", "user_info",
					"authorization_code,check_token,refresh_token,password", "http://localhost:8081/login", "ADMIN,ANALYST", 1000000, 1000000,
					null, "true");
			oauthClientDetailsRepository.save(oauthClientDetails);
			System.out.println("DefaultDataLoader.onApplicationEvent() made entry into oauth_client_details table");
		}
		
		if(oauthAccessTokenRepository.count() > 0) {
			System.out.println("DefaultDataLoader.onApplicationEvent() oauthAccessTokenRepository count > 0");
			Iterable<OauthAccessToken> oauthAccessTokenIterable = oauthAccessTokenRepository.findAll();
			while(oauthAccessTokenIterable.iterator().hasNext()){
				OauthAccessToken oauthAccessToken = oauthAccessTokenIterable.iterator().next();
				System.out.println("oauthAccessToken value: "+oauthAccessToken.toString());
			}
		}
		
		if(oauthRefreshTokenRepository.count() > 0) {
			System.out.println("DefaultDataLoader.onApplicationEvent() oauthRefreshTokenRepository count > 0");
			Iterable<OauthRefreshToken> oauthRefreshTokenIterable = oauthRefreshTokenRepository.findAll();
			while(oauthRefreshTokenIterable.iterator().hasNext()){
				OauthRefreshToken oauthRefreshToken = oauthRefreshTokenIterable.iterator().next();
				System.out.println("oauthRefreshToken value: "+oauthRefreshToken.toString());
			}
		}
		
	}

}
