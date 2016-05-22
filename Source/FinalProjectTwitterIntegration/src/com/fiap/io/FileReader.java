package com.fiap.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

	private Path path;

	public FileReader(String filePath) {
		path = Paths.get(filePath);
	}

	protected List<String> getListContent() throws IOException {
		return Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)
					.lines().collect(Collectors.toList());
	}
}
