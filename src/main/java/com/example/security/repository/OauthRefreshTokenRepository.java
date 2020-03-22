package com.example.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.security.domain.OauthRefreshToken;

public interface OauthRefreshTokenRepository extends CrudRepository<OauthRefreshToken,String>{
	

}
