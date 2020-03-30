import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DuplicateCounter {
	// create map for wordcounter
	private Map<String, Integer> wordCounter = new HashMap<String, Integer>();

	public void count(String dataFile) {
		// create scanner
		Scanner file = null;

		// catch file not found exception
		try {

			file = new Scanner(new File(dataFile));

		} catch (FileNotFoundException exception) {

			System.out.println("Problem trying to find/open the file file: " + dataFile);
			System.exit(0);

		}

		// delim using spaces to seperate words (this will count punctuated words
		// seperatly
		file.useDelimiter("\\s+");

		// loop for the words and how many times appear
		while (file.hasNext()) {

			// Cast all words to lowercase
			String word = file.next().toLowerCase();

			// frequency counter
			Integer amount = wordCounter.get(word);

			// check if null, if so set to one
			if (amount == null) {

				amount = 1;

			}
			// else increase
			else {

				amount += 1;

			}
			// adds the word and amount found
			wordCounter.put(word, amount);
		}
		// terminate file stream
		file.close();

	}

	public void write(String outputFile) {

		// catch file write error
		try {

			// file io
			PrintWriter file = new PrintWriter(new File(outputFile));

			// iterate though pairs and write them to file
			for (String word : wordCounter.keySet()) {

				file.println(word + " " + wordCounter.get(word));

			}
			file.close();

		} catch (FileNotFoundException exception) {

			System.out.println("Problem trying to write to the file: " + outputFile);

		}
	}

}