package com.fiap.model;

import java.util.List;
import twitter4j.Status;

public class Tweet {

	private TweetType type;
	private List<Status> tweets;
	
	public TweetType getType() {
		return type;
	}
	public void setType(TweetType type) {
		this.type = type;
	}
	public List<Status> getTweets() {
		return tweets;
	}
	public void setTweets(List<Status> tweets) {
		this.tweets = tweets;
	}
}