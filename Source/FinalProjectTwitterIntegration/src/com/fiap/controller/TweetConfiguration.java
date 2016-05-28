package com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetConfiguration {

	private static int count = 0;
	private static List<ConfigurationBuilder> cbs = buildConfiguration();
	
	public static Twitter getInstance(){
		ConfigurationBuilder cb = getConfig();	
		if(cb != null)
			return new TwitterFactory(cb.build()).getInstance();
		else
			return null;
	}
	
	private static ConfigurationBuilder getConfig(){
		if(cbs.size() > count)
			return cbs.get(count++);
		else
			return null;
	}
	
	private static List<ConfigurationBuilder> buildConfiguration(){
		cbs = new ArrayList<>();
		
		ConfigurationBuilder cb1 = new ConfigurationBuilder();
		cb1.setOAuthConsumerKey("3QRfILThjzQslxSRLps8u3tDv");
		cb1.setOAuthConsumerSecret("exr4sElb7yLxXomoqNyo9aDLc29FoTnnAfia8c34Nzv1V4p5ED");
		cb1.setOAuthAccessToken("729051384688066560-mR8PP2fslrG0fRCen6QYWhQ1gpTFcV2");
		cb1.setOAuthAccessTokenSecret("iv8Nl75gAw0smCSMdVmlwGXViMMpD6VeEgNeAn7btFqIs");
		cbs.add(cb1);
		
		ConfigurationBuilder cb2 = new ConfigurationBuilder();
		cb2.setOAuthConsumerKey("YHzoBOWlBlUsM6g4kL4vjK4sA");
		cb2.setOAuthConsumerSecret("c4jJXYwqEibZfcjjo2ccS9YalJDD5o5mmlOBi4HPwEiBpGKglC");
		cb2.setOAuthAccessToken("736366166654996480-trHVnCyz345bGfTemFh6afH4pF9Qtda");
		cb2.setOAuthAccessTokenSecret("ByODwFhRAF1PiB0yvf8ctGRuy78i2K4XZhsIHC1qczhD7");
		cbs.add(cb2);
		
		ConfigurationBuilder cb3 = new ConfigurationBuilder();
		cb3.setOAuthConsumerKey("0ejGbtK10mr50WX6KBszvJCrw");
		cb3.setOAuthConsumerSecret("mJ0GgB8rjHphQhYyrSJyu1ExmT5y7iIE3yGPnM7WyHF0Ru4Nak");
		cb3.setOAuthAccessToken("736366166654996480-PkdyUdz7Xp3flBgOtLZKHN8qK8mWlQL");
		cb3.setOAuthAccessTokenSecret("Oo6mQv6EsosWbg7oDf7DfeafPR1ecQptYyv66b4qxmawd");
		cbs.add(cb3);
		
		ConfigurationBuilder cb4 = new ConfigurationBuilder();
		cb3.setOAuthConsumerKey("Tuj7Vsc0Ya1qQkX5navLDa0SE");
		cb3.setOAuthConsumerSecret("ZdhsYBaRUhoQ171fdwRDbKcN5dXpNs9CCqb6GULmfDRHqLqmxI");
		cb3.setOAuthAccessToken("736366166654996480-QpeWrJl4schWanrykKxkZPyS6miEUi7");
		cb3.setOAuthAccessTokenSecret("iile5ZmvmZTwke09VLPOCXJj3EMGw6pP4m12Lsm7qW7nf");
		cbs.add(cb4);
		
		return cbs;
	}
	
	public static Twitter getSenderInstance(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("pkblQKCSLbO6DR5tbLQxftC26");
		cb.setOAuthConsumerSecret("F2TLB8tQpX5jGvUTbndchz6GyrSBkszxVJ94AHXzhbIPrx3aes");
		cb.setOAuthAccessToken("729051384688066560-bNjs6rfo3H2zxlbfwcrkUULB7L0IyTb");
		cb.setOAuthAccessTokenSecret("Sx1VG6ea33OvlpTk5fp59Y542vZKkyItBSUDpjDhQ9Hkd");
		return new TwitterFactory(cb.build()).getInstance();
	}
	
}
