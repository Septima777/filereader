package filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendStringBuilderTask implements Runnable {

	private String filename;
	private int fileSize;

	public AppendStringBuilderTask(String filename) {
		this.filename = filename;
	}

	public static String readFileToStringBuilder(String filename) {
		// create a string for the data to read
		StringBuilder data = new StringBuilder();
		InputStream in = null;
		InputStreamReader reader = null;
		try {
			// open the file
			in = new FileInputStream(filename);
			// read as characters, so what to do?
			reader = new InputStreamReader(in);
			// read the file
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data.append((char) c);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// close the file
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				
			}
		}
		return data.toString();
	}

	@Override
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using FileReader, append to String. \nRead %,d chars ",
				fileSize);
	}

	@Override
	public void run() {
		String file = readFileToStringBuilder(filename);
		this.fileSize = file.length();
	}
}
