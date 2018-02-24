package filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class read a text file one character at a time. Append all the
 * characters to a String and return the String.
 * 
 * @author Noppawan Kulchol
 *
 */
public class AppendStringTask implements Runnable {

	/** name of the file */
	private String filename;
	/** size of the file */
	private int fileSize;

	/**
	 * Initialize name of the file.
	 * 
	 * @param filename
	 */
	public AppendStringTask(String filename) {
		this.filename = filename;
	}

	/**
	 * Read a text file one character at a time. Append all the characters to a
	 * String and return the String.
	 * 
	 * @param filename
	 *            is name of file that need to read.
	 */
	public static String readFileToString(String filename) {
		InputStream in = null;
		InputStreamReader reader = null;
		// create String for the data to read
		String data = "";
		try {
			// open the file
			in = new FileInputStream(filename);
			// read as characters
			reader = new InputStreamReader(in);
			// read the file
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data + (char) c;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// close the file
		if (reader != null)
			try {
				reader.close();
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
		return String.format("Reading Alice-in-Wonderland.txt using FileReader, append to String. \nRead %,d chars ",
				fileSize);
	}

	/**
	 * get size of the file.
	 */
	@Override
	public void run() {
		String file = readFileToString(filename);
		this.fileSize = file.length();
	}

}
