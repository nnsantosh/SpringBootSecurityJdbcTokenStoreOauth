package com.example.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.security.domain.OauthAccessToken;

public interface OauthAccessTokenRepository extends CrudRepository<OauthAccessToken,String>{

}
