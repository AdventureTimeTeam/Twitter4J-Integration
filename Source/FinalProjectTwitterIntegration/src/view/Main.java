package view;

import java.util.ArrayList;
import java.util.List;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Main {

	public static void main(String[] args) throws Exception{
		try {
			
			ConfigurationBuilder cb1 = new ConfigurationBuilder();
			cb1.setOAuthConsumerKey("3QRfILThjzQslxSRLps8u3tDv");
			cb1.setOAuthConsumerSecret("exr4sElb7yLxXomoqNyo9aDLc29FoTnnAfia8c34Nzv1V4p5ED");
			cb1.setOAuthAccessToken("729051384688066560-mR8PP2fslrG0fRCen6QYWhQ1gpTFcV2");
			cb1.setOAuthAccessTokenSecret("iv8Nl75gAw0smCSMdVmlwGXViMMpD6VeEgNeAn7btFqIs");
			ConfigurationBuilder cb2 = new ConfigurationBuilder();
			cb2.setOAuthConsumerKey("YHzoBOWlBlUsM6g4kL4vjK4sA");
			cb2.setOAuthConsumerSecret("c4jJXYwqEibZfcjjo2ccS9YalJDD5o5mmlOBi4HPwEiBpGKglC");
			cb2.setOAuthAccessToken("736366166654996480-trHVnCyz345bGfTemFh6afH4pF9Qtda");
			cb2.setOAuthAccessTokenSecret("ByODwFhRAF1PiB0yvf8ctGRuy78i2K4XZhsIHC1qczhD7");
			ConfigurationBuilder cb3 = new ConfigurationBuilder();
			cb3.setOAuthConsumerKey("0ejGbtK10mr50WX6KBszvJCrw");
			cb3.setOAuthConsumerSecret("mJ0GgB8rjHphQhYyrSJyu1ExmT5y7iIE3yGPnM7WyHF0Ru4Nak");
			cb3.setOAuthAccessToken("736366166654996480-PkdyUdz7Xp3flBgOtLZKHN8qK8mWlQL");
			cb3.setOAuthAccessTokenSecret("Oo6mQv6EsosWbg7oDf7DfeafPR1ecQptYyv66b4qxmawd");
			List<ConfigurationBuilder> cbs = new ArrayList<>();
			cbs.add(cb1);
			cbs.add(cb2);
			cbs.add(cb3);
			
			
			 Twitter twitter = null;
			  Query query = new Query("#java void");
			  //query.setSince("2016-05-20");
			  //query.setUntil("2016-05-20");
			  int numberOfTweets = 600;
			  int count = 0;
			  long lastID = Long.MAX_VALUE;
			  ArrayList<Status> tweets = new ArrayList<Status>();
			  twitter = new TwitterFactory(cbs.get(2).build()).getInstance();
			  while (tweets.size () < numberOfTweets) {
				  
				/*if(count <= 180){
					if(twitter == null)
						twitter = new TwitterFactory(cbs.get(0).build()).getInstance();
					if(count == 180)
						twitter = null;
				}
				else if(count > 180 && count <= 360){
					if(twitter == null)
						twitter = new TwitterFactory(cbs.get(1).build()).getInstance();
					if(count == 360)
						twitter = null;
				}
				else {
					if(twitter == null)
						twitter = new TwitterFactory(cbs.get(2).build()).getInstance();
				}*/
			  
			  	count++;
				  
			    if (numberOfTweets - tweets.size() > 100)
			      query.setCount(100);
			    else 
			      query.setCount(numberOfTweets - tweets.size());
			    try {
			      QueryResult result = twitter.search(query);
			      tweets.addAll(result.getTweets());
			      System.out.println("Gathered " + tweets.size() + " tweets");
			      for (Status t: tweets) 
			        if(t.getId() < lastID) lastID = t.getId();

			    }

			    catch (TwitterException te) {
			    	System.out.println("Couldn't connect: " + te);
			    }; 
			    query.setMaxId(lastID-1);
			  }

			  for (int i = 0; i < tweets.size(); i++) {
			    Status t = (Status) tweets.get(i);

			    GeoLocation loc = t.getGeoLocation();

			    String user = t.getUser().getScreenName();
			    String msg = t.getText();
			    String time = "";
			    if (loc!=null) {
			      Double lat = t.getGeoLocation().getLatitude();
			      Double lon = t.getGeoLocation().getLongitude();
			      System.out.println(i + " USER: " + user + " wrote: " + msg + " located at " + lat + ", " + lon + ", date: " + t.getCreatedAt());
			    } 
			    else 
			    	System.out.println(i + " USER: " + user + " wrote: " + msg + ", date: " + t.getCreatedAt());
			  }
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
