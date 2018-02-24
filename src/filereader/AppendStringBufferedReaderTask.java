package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppendStringBufferedReaderTask implements Runnable{

	private String fileName;
	private int fileSize;
	
	public AppendStringBufferedReaderTask(String fileName) {
		this.fileName = fileName;
	}
	
	public static String readFileToStringBufferedReder(String filename) {
		// create a string for the data to read
		FileReader reader;
		BufferedReader bufferReader = null;
		String data = "";
		String line;
		try {
			// open the file
			reader = new FileReader(filename);
			// read as characters, so what to do?
			bufferReader = new BufferedReader(reader);
			// read the file
			while ((line = bufferReader.readLine()) != null) { 
				data = data + line + '\n';
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// close the file
		if(bufferReader != null)
			try {
			bufferReader.close();
		} catch (IOException e) {
			
		}
		return data;
	}
	
	@Override
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String. \nRead %,d chars ", fileSize);
	}

	@Override
	public void run() {
		String file = readFileToStringBufferedReder(fileName);
		this.fileSize = file.length();
	}
	
}
