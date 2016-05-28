package com.fiap.controller;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/*
 * Consumer Key:	3QRfILThjzQslxSRLps8u3tDv
 * Consumer Secret:	exr4sElb7yLxXomoqNyo9aDLc29FoTnnAfia8c34Nzv1V4p5ED
 * 
 * Access Token:	729051384688066560-mR8PP2fslrG0fRCen6QYWhQ1gpTFcV2
 * Access Token Secret:	iv8Nl75gAw0smCSMdVmlwGXViMMpD6VeEgNeAn7btFqIs
 */

public class TwitterService {

	
	private String consumerKey;
	private String consumerSecret;
	
	private TwitterService(String consumerKey, String consumerSecret){
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	public TwitterService(){
		this.consumerKey = "3QRfILThjzQslxSRLps8u3tDv";
		this.consumerSecret = "exr4sElb7yLxXomoqNyo9aDLc29FoTnnAfia8c34Nzv1V4p5ED";
	}
	
	public static TwitterService getConnection(String consumerKey, String consumerSecret){
		return new TwitterService(consumerKey, consumerSecret);
		 
	}
	public Twitter userAuthentication(String token, String tokenSecret) throws Exception{
		try {
			ConfigurationBuilder builder = new ConfigurationBuilder();
			builder.setOAuthConsumerKey(consumerKey);
			builder.setOAuthConsumerSecret(consumerSecret);
			Configuration configuration = builder.build();
			
			TwitterFactory factory = new TwitterFactory(configuration);
			Twitter twitter = factory.getInstance();
			twitter.setOAuthAccessToken(new AccessToken(token, tokenSecret));
			
			return twitter; //Return Twitter
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
