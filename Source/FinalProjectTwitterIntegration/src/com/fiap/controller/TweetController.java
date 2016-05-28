package com.fiap.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TweetController {

	private static ArrayList<Status> tweets = new ArrayList<Status>();
	private static Twitter currentTwitterInstance = null;
	private static Twitter currentSenderInstance = null;
	private FileWriter file;
	
	public TweetController(){
		currentTwitterInstance = TweetConfiguration.getInstance();
		currentSenderInstance = TweetConfiguration.getSenderInstance();
	}
	
	
	public ArrayList<Status> getAllTweets(Query query) throws IOException {
		try {
			
			while (true) {
				try {
					QueryResult result = currentTwitterInstance.search(query);
					tweets.addAll(result.getTweets());
					System.out.println("Getting tweets " + tweets.size() + "...");
				} catch (TwitterException e) {
					currentTwitterInstance = TweetConfiguration.getInstance();
					if (currentTwitterInstance == null)
						break;
				}
			}			
		} catch (Exception e) {
			System.out.println("Ops! You need to wait at least 15 minutes!"); 
		}

		file = new FileWriter("c:\\Temp\\Tweets\\AllTweets.txt", true);
		for (Status status : tweets) {
			String output = "\nUser: " + status.getUser().getScreenName() + "\nText: " + status.getText()
					+ "\nDate: " + status.getCreatedAt() + "\nFavorite: " + status.getFavoriteCount() 
					+ "\nRetweet: " + status.getRetweetCount();
			file.write(output);
		}
			
		return tweets;
	}

	public long getAmountTweetsFromLastWeek() {
		return tweets.stream().filter(t -> t.isFavorited() == false && t.isRetweet() == false).count();
	}

	public long getAmountReTweetsFromLastWeek() {
		return tweets.stream().filter(t -> t.isRetweet()).count();
	}

	public long getAmountFavoritesFromLastWeek() {
		return tweets.stream().filter(t -> t.isFavorited()).count();
	}

	public List<Status> getAuthorTwitterSorted() {
		return tweets.stream()
				.sorted((e1, e2) -> e1.getUser().getName()
						.compareTo(e2.getUser().getName()))
				.collect(Collectors.toList());
	}

	public List<Status> getDateTwitterSorted() {
		return tweets.stream()
				.sorted((e1, e2) -> e1.getCreatedAt()
						.compareTo(e2.getCreatedAt()))
				.collect(Collectors.toList());
	}

	public void tweet(String message) throws TwitterException {
		currentSenderInstance.updateStatus(message);
	}

	public void sincronizeIoT() {

	}
	
	
	
}
