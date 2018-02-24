package filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class read a text file one character at a time. Append all the
 * characters to a StringBuilder and return the StringBuilder.toString().
 * @author Noppawan Kulchol
 *
 */
public class AppendStringBuilderTask implements Runnable {

	/** name of the file */
	private String filename;
	/** size of the file */
	private int fileSize;

	/**
	 * Initialize name of the file.
	 * 
	 * @param filename
	 */
	public AppendStringBuilderTask(String filename) {
		this.filename = filename;
	}

	/**
	 * Read a text file one character at a time. Append all the characters to a
	 * StringBuilder and return the StringBuilder.toString().
	 * 
	 * @param filename
	 *            is name of file that need to read.
	 */
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
				in.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data.toString();
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
		String file = readFileToStringBuilder(filename);
		this.fileSize = file.length();
	}
}
