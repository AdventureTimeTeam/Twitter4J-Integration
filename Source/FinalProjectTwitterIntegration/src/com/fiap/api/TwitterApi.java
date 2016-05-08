package com.fiap.api;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

public class TwitterApi {

	private final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";

	public void authenticate() {
		try {
			final OAuth10aService service = new ServiceBuilder().apiKey(System.getProperty("api.twitter.key"))
					.apiSecret(System.getProperty("api.twitter.secret"))
					.build(com.github.scribejava.apis.TwitterApi.instance());

			final OAuth1RequestToken requestToken = service.getRequestToken();
			System.out.println(service.getAuthorizationUrl(requestToken));
			final OAuth1AccessToken accessToken = service.getAccessToken(requestToken,
					System.getProperty("api.twitter.oauth_verifier"));
			System.out.println("Access Token: " + accessToken);

			final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
			service.signRequest(accessToken, request);
			final Response response = request.send();
			System.out.println(response.getBody());
		} catch (Exception ex) {
			throw ex;
		}
	}
}
