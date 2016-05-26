package com.fiap.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;

public class TweetSearch {
	
	private Twitter twitter;
	private String wordRequired;
	private List<Status> tweets = new ArrayList<>();
	
	public TweetSearch(Twitter twitter) {
		this.twitter = twitter;
	}

	public List<Status> getTweetsFromTheLast7days(String query){
		wordRequired = query;
		setupDates();
		return tweets;
	}

	private synchronized void setupDates(){

		LocalDate date = LocalDate.now();
		String tomorrow = date.plusDays(1).toString();
		String today = date.toString();
		String yesterday = date.minusDays(1).toString();
		String twoDaysAgo = date.minusDays(2).toString();
		String threeDaysAgo = date.minusDays(3).toString();
		String fourDaysAgo = date.minusDays(4).toString();
		String fiveDaysAgo = date.minusDays(5).toString();
		String sixDaysAgo = date.minusDays(6).toString();
		
		List<String> days = Arrays.asList(sixDaysAgo, fiveDaysAgo, fourDaysAgo, threeDaysAgo, twoDaysAgo, yesterday, today, tomorrow);
		
		for(int i=0; i < days.size(); i++){
			if(days.size() > i+1){
				getTweets(days.get(i), days.get(i+1));
				try {
					wait(140_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void getTweets(String date, String date1){
		QueryResult result;
		try {
			Query query = new Query(wordRequired)
					.count(100)
					.since(date)
					.until(date1);
			
			do {
				result = twitter.search(query);
				tweets.addAll(result.getTweets());              
			} while ((query = result.nextQuery()) != null);
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public void save(){
		try {
			Formatter write = new Formatter(new File("Tweets/" + LocalTime.now() + ".txt"));
			int i = 0;
			for(Status status : tweets){
				write.format("%3d %22s %40s isRetweet:%6b isRetweeted:%10b getRetweetCount:%5d\n", 
						++i, status.getUser().getName(), status.getCreatedAt(), status.isRetweet(), status.isRetweeted(), status.getRetweetCount());
			}
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
