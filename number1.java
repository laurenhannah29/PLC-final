import java.io.*;
import java.util.Scanner;

public class LexicalAnalyzer {
	String keywords[] = {"for", "if", "assignment", "while", "do", "switch", "foreach", "return", "block", "break"};
	String fileWords[];
	int tokenCount[];
	int counter = 0;

	void readFile() {
		Scanner readF = null;
		try {
			readF = new Scanner(new File("javaProgram.txt"));
			while(readF.hasNext()) {
				readF.next();
				counter++;
			}

			fileWords = new String[counter];
			counter = 0;
			readF = new Scanner(new File("javaProgram.txt"));
			while(readF.hasNext())
				fileWords[counter++] = readF.next();

		}
		catch(FileNotFoundException fe) {
			System.err.println("Unable to open the file fore reading.");

		}

	}

	void countToken() {
		String token = "";
		tokenCount = new int[keywords.length];
		for(int c = 0; c < keywords.length; c++)
			tokenCount[c] = 0;

		for(int c = 0; c < fileWords.length; c++) {
			for(int d = 0; d < keywords.length; d++) {
				if(fileWords[c].length() > keywords[d].length())
					token = fileWords[c].substring(0, keywords[d].length());
				else
					token = fileWords[c];
				if(token.compareTo(keywords[d]) == 0)
					tokenCount[d]++;
			}
		}
	}

	void show() {
		for(int c = 0; c < keywords.length; c++)
			System.out.println("Token: " + keywords[c] + ", " + tokenCount[c]);
	}

	public static void main(String mohan[]) {
		LexicalAnalyzer tf = new LexicalAnalyzer();
		tf.readFile();
		tf.countToken();
		tf.show();
	}

}
