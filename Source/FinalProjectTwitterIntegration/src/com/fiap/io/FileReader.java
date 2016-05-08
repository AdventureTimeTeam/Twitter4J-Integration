package com.fiap.io;

import java.io.File;

public class FileReader<T> {

	protected String filePath;
	private File file;

	public FileReader(String filePath) {
		this.filePath = filePath;
	}

	protected void openFile() {

	}

	protected void closeFile() {

	}

	protected T getFile() {
		return null;
	}

	protected void setFile(File file) {

	}

	protected void setFile(String filePath) {

	}
}
