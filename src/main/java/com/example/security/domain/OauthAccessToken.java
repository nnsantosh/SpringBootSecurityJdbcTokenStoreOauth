package com.example.security.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OauthAccessToken {

	@Id
	private String authenticationId;
	private String tokenId;
	private byte[] token;
	private String userName;
	private String clientId;
	private byte[] authentication;
	private String refreshToken;

	public OauthAccessToken() {

	}

	public OauthAccessToken(String authenticationId, String tokenId, byte[] token, String userName, String clientId,
			byte[] authentication, String refreshToken) {
		super();
		this.authenticationId = authenticationId;
		this.tokenId = tokenId;
		this.token = token;
		this.userName = userName;
		this.clientId = clientId;
		this.authentication = authentication;
		this.refreshToken = refreshToken;
	}

	@Override
	public String toString() {
		return "OauthAccessToken [authenticationId=" + authenticationId + ", tokenId=" + tokenId + ", token="
				+ Arrays.toString(token) + ", userName=" + userName + ", clientId=" + clientId + ", authentication="
				+ Arrays.toString(authentication) + ", refreshToken=" + refreshToken + "]";
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
