package com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import com.fiap.model.TwitterData;

import twitter4j.Status;
import twitter4j.Twitter;

public class TweetController {

	private TwitterData twitterData = new TwitterData();
	private List<Status> tweets = new ArrayList<>();
	
	public void searchBy(){
		TwitterService t = TwitterService.getConnection(
				"3QRfILThjzQslxSRLps8u3tDv", "exr4sElb7yLxXomoqNyo9aDLc29FoTnnAfia8c34Nzv1V4p5ED");
		try {
			Twitter twitter = t.userAuthentication(
					"729051384688066560-mR8PP2fslrG0fRCen6QYWhQ1gpTFcV2", "iv8Nl75gAw0smCSMdVmlwGXViMMpD6VeEgNeAn7btFqIs");
		
			TweetSearch tweetSearch = new TweetSearch(twitter);
			tweets = tweetSearch.getTweetsFromTheLast7days("#java");
			tweetSearch.save();
			long numOfRetweets = tweets.stream().filter(tweet -> tweet.isRetweet()).count();
			long numOfTweets = tweets.stream().filter(tweet -> !tweet.isRetweet()).count();
			long numOfFavorites = tweets.stream().filter(tweet -> !tweet.isFavorited()).count();
			System.out.println("Total:"+tweets.size()+"\nRetweets: "+numOfRetweets+"\nTweets: "+numOfTweets+"\nFavorite: "+numOfFavorites);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int getAmountTweetsFromLastWeek(){
		return tweets.size();
	}
	
	public int getAmountReTweetsFromLastWeek(){
		return -1;
	}
	
	public int getAmountFavoritesFromLastWeek(){
		return -1;
	}
	
	public String getAuthorTwitterSorted(List<Status> tweets){
		//4) Ordenar os tweets pelo nome do autor, e exibir o primeiro nome e o último nome.
		
		//LAMBDA THAT SORT BY ALPHABETIC ORDER
		tweets.sort((twitt1, twitt2) -> {
			return twitt1.getUser().getName().compareToIgnoreCase(twitt2.getUser().getName());
		});
		twitterData.setFirstNameAlphabeticalOrder(tweets.get(0));
		twitterData.setLastNameAlphabeticalOrder(tweets.get(tweets.size()-1));
		
		return null;
	}
	
	public String getDateTwitterSorted(List<Status> tweets){
		//5) Ordenar os tweets por data, e exibir a data mais recente e a menos recente.
		
		//LAMBDA THAT SORT BY DATE
		tweets.sort((tweet1, tweet2) -> {
			if(tweet1.getCreatedAt().after(tweet2.getCreatedAt())){
				return 1;
			}else if(tweet1.getCreatedAt().equals(tweet2.getCreatedAt())){
				return 0;
			} else {
				return -1;
			}
		});
		twitterData.setLessRecent(tweets.get(tweets.size()-1));
		twitterData.setMostRecent(tweets.get(0));
		
		return null;
	}
	
	public void generateTweet(){
		
	}
	
	public void setReferenceUser(String twitterUser){
		
	}
	
	public void sincronizeIoT(){
		
	}
	
	@Override
	public String toString() {
		// Return string to console
		return super.toString();
	}
}
