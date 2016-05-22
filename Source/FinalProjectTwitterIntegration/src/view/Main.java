package view;

import java.io.IOException;

import com.fiap.io.TwitterFileReader;

public class Main {

	public static void main(String[] args){
		try {
			//new PropertiesReader().loadProperties();
			//System.out.println(System.getProperty("api.twitter.test"));
			
			new TwitterFileReader().getTweets();
			
			//System.out.println(prop.getProperty("api.twitter.test"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
