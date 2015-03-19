package answers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {

	private String filename;
	private File file;
	private FileReader fr;
	private String[] cards;

	public FileOperations(String startFilename) throws IOException {
		setFilename(startFilename);
		file = new File(filename);
	}

	public String[] openFile() throws IOException {
		fr = new FileReader(file);

		char[] a = new char[(int) file.length()];
		fr.read(a); // reads the content to the array
		cards = new String(a).split(" ");
		fr.close();
		return cards;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
