package com.example.security.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OauthRefreshToken {

	@Id
	private String tokenId;
	private byte[] token;
	private byte[] authentication;

	public OauthRefreshToken() {

	}

	public OauthRefreshToken(String tokenId, byte[] token, byte[] authentication) {
		super();
		this.tokenId = tokenId;
		this.token = token;
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "OauthRefreshToken [tokenId=" + tokenId + ", token=" + Arrays.toString(token) + ", authentication="
				+ Arrays.toString(authentication) + "]";
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

}
