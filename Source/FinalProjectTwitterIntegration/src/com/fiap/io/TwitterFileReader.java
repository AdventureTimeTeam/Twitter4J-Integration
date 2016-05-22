package com.fiap.io;

import java.io.IOException;
import java.util.List;

import com.fiap.model.Tweet;

public class TwitterFileReader extends FileReader {

	public TwitterFileReader() {
		super("c:\\Temp\\twitter-files\\");
	}

	public List<Tweet> getTweets() throws IOException{
		List<String> content = super.getListContent();
		Tweet tweet;
		for(String line : content){
			tweet = new Tweet();
			
		}
		
		return null;
	}
}
