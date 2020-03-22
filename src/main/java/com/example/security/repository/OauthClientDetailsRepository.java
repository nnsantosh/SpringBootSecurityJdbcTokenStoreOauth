package com.example.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.security.domain.OauthClientDetails;

public interface OauthClientDetailsRepository extends CrudRepository<OauthClientDetails, String> {

}
