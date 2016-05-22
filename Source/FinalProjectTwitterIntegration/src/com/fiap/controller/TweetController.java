package com.fiap.controller;

import java.util.List;

import com.fiap.model.TwitterData;

import twitter4j.Status;

public class TweetController {

	private TwitterData twitterData = new TwitterData();
	
	public int getAmountTweetsFromLastWeek(){
		return -1;
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
