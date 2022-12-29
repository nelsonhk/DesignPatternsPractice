package spellcheck;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
			URL url = new URL(args[0]);
//			Scanner scanner = new Scanner(System.in);
//			URL url = new URL(scanner.nextLine());

			// Now, main depends on concrete types, but SpellingChecker is no longer violating
			// the DIP; main can figure itself out however it wants :)
			URLFetcher fetcher = new URLFetcher();
			Dictionary dictionary = new Dictionary("dict.txt");
			WordExtractor extractor = new WordExtractor();

			SpellingChecker checker = new SpellingChecker(url, fetcher, extractor, dictionary);
			SortedMap<String, Integer> mistakes = checker.check(url);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

