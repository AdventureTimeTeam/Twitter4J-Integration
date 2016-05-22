package com.fiap.model;

import twitter4j.Status;

public class TwitterData {

	private int numberOfTweets;
	private int numberOfRetweets;
	private int numberOflikes;
	private Status firstNameAlphabeticalOrder;
	private Status lastNameAlphabeticalOrder;
	private Status mostRecent;
	private Status lessRecent;
	
	public int getNumberOfTweets() {
		return numberOfTweets;
	}
	public void setNumberOfTweets(int numberOfTweets) {
		this.numberOfTweets = numberOfTweets;
	}
	public int getNumberOfRetweets() {
		return numberOfRetweets;
	}
	public void setNumberOfRetweets(int numberOfRetweets) {
		this.numberOfRetweets = numberOfRetweets;
	}
	public int getNumberOflikes() {
		return numberOflikes;
	}
	public void setNumberOflikes(int numberOflikes) {
		this.numberOflikes = numberOflikes;
	}
	public Status getFirstNameAlphabeticalOrder() {
		return firstNameAlphabeticalOrder;
	}
	public void setFirstNameAlphabeticalOrder(Status firstNameAlphabeticalOrder) {
		this.firstNameAlphabeticalOrder = firstNameAlphabeticalOrder;
	}
	public Status getLastNameAlphabeticalOrder() {
		return lastNameAlphabeticalOrder;
	}
	public void setLastNameAlphabeticalOrder(Status lastNameAlphabeticalOrder) {
		this.lastNameAlphabeticalOrder = lastNameAlphabeticalOrder;
	}
	public Status getMostRecent() {
		return mostRecent;
	}
	public void setMostRecent(Status mostRecent) {
		this.mostRecent = mostRecent;
	}
	public Status getLessRecent() {
		return lessRecent;
	}
	public void setLessRecent(Status lessRecent) {
		this.lessRecent = lessRecent;
	}
}
