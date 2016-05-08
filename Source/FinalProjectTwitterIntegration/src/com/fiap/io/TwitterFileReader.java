package com.fiap.io;

import java.io.File;

public class TwitterFileReader<T> extends FileReader<Object> {

	public TwitterFileReader(String filePath) {
		super(filePath);
	}

	@Override
	public T getFile(){
		return null;
	}
	
	@Override
	public void setFile(String fileJson){
		
	}
	
	@Override
	public void setFile(File file){
		
	}
}
