package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class Read a text file one line at a time. Append each line 
 * to the String containing file data.
 * @author Noppawan Kulchol
 *
 */
public class AppendStringBufferedReaderTask implements Runnable{

	/** name of the file */
	private String fileName;
	/** size of the file */
	private int fileSize;
	
	/**
	 * Initialize name of the file.
	 * 
	 * @param filename
	 */
	public AppendStringBufferedReaderTask(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Read a text file one line at a time. Append each line 
	 * to the String containing file data.
	 * 
	 * @param filename
	 *            is name of file that need to read.
	 */
	public static String readFileToStringBufferedReder(String filename) {
		// create a string for the data to read
		FileReader reader;
		BufferedReader bufferReader = null;
		String data = "";
		String line;
		try {
			
			reader = new FileReader(filename);
			bufferReader = new BufferedReader(reader);
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
	
	/**
	 * print the description.
	 * 
	 * @return description into String.
	 */
	@Override
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String. \nRead %,d chars ", fileSize);
	}

	/**
	 * get size of the file.
	 */
	@Override
	public void run() {
		String file = readFileToStringBufferedReder(fileName);
		this.fileSize = file.length();
	}
	
}
