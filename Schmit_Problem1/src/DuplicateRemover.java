/*Problem 1: Problem 1 shall contain a public class called DuplicateRemover
Problem 1: DuplicateRemover shall contain a method called remove
Problem 1: Given the path to a text file, the remove method shall determine the unique words contained in dataFIle and store those unique words in the associated DuplicateRemover object
Problem 1: The remove method shall terminate the program and alert the user with a user-friendly message when an exceptional IO event occurs
Problem 1: The remove method shall clean up any and all resources allocated during method execution
Problem 1: DuplicateRemover shall contain a method called write
Problem 1: Given the path to a text file, the write method shall print the current collection of unique words to outputFile
Problem 1: The write method shall terminate the program and alert the user with a user-friendly message when an exceptional IO event occurs
Problem 1: The write method shall clean up any and all resources allocated during method execution
Problem 1: Problem 1 shall contain a public class called Application
Problem 1: Application shall contain a main method
Problem 1: The main method shall create an instance of a DuplicateRemover called duplicateRemover
Problem 1: The main method shall use the write method of duplicateRemover to output the unique words of "problem1.txt" to a file called "unique_words.txt"
*/

import java.util.Set;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.io.File;
import java.io.FileWriter;

public class DuplicateRemover {

	Set <String> uniqueWords;

	void remove(String dataFile) {
		
		Scanner fileData = null;
		
		try {
			
			//make variable store strings from file
			uniqueWords = new LinkedHashSet<>();
			
			//scanner to read the file
			fileData = new Scanner(new File(dataFile)); 
			
			//reads the file for words
			while (fileData.hasNextLine()) {
				
				//reads a line from the file
				String line = fileData.nextLine(); 
				
				//space delim
				String[] wordList = line.split("\\s+");
				
				//loop to convert all letters to lowercase as to not double count later
				for (int i = 0; i < wordList.length; i++) {
					
					//convert letters to lower case
					String word = wordList[i].toLowerCase();
					
					//add the words into the 
					uniqueWords.add(word);
				}
			}
		} catch (Exception exception) {
			
			System.out.println("Cannot open or locate file: " + dataFile);
			
		}
		
		//close scanner if not empty
		if(fileData != null) {
			
			fileData.close();
			
		}

	}

	void write(String outputFile){
		
		FileWriter output = null;
		
		try {
			
			//open the file
			output = new FileWriter(outputFile);
			
			//loop through the words in uniqueWords
			for (String word : uniqueWords) {
				
				//write each word to the file 
				output.write(word + "\n");
				
			}
			
			//close file
			output.close();
			
		} catch (Exception exception) { 
			
			System.out.println("Problem trying to write to the file: " + outputFile);
			
		}

	}

}