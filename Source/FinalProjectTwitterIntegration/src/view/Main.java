package view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fiap.controller.TweetController;
import com.fiap.controller.TweetQuery;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		TweetController tweetCont = new TweetController();
		tweetCont.getAllTweets(new TweetQuery().getQuery());
		//tweetCont.getAllTweets(new TweetQuery().getQueryLastWeek());
		String totalTweets = "Total Tweets from Last Week: " + tweetCont.getAmountTweetsFromLastWeek();
		String totalReTweets = "Total ReTweets from Last Week: " + tweetCont.getAmountReTweetsFromLastWeek();
		String totalFavorites = "Total Favorite Tweets from Last Week: " + tweetCont.getAmountFavoritesFromLastWeek();

		FileWriter fileAuthor = new FileWriter("c:\\Temp\\Tweets\\TweetsByAuthor.txt", true);
		FileWriter fileDate = new FileWriter("c:\\Temp\\Tweets\\TweetsByDate.txt", true);
		
		List<Status> listTweetByAuthor = tweetCont.getAuthorTwitterSorted();
		List<Status> listTweetByDate = tweetCont.getDateTwitterSorted();
		
		for(Status status : listTweetByAuthor){
			fileAuthor.write(status.getUser().getName() + "\n");
		}
			
		for(Status status : listTweetByDate){
			fileDate.write(status.getCreatedAt().toString() + "\n");
		}
		
		fileAuthor.close();
		fileDate.close();
		
		// @michelpf
		try {
			tweetCont.tweet("Ola @eheinen2 !!!\n" + totalTweets + "\n" + totalReTweets + "\n" + totalFavorites);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}


}
