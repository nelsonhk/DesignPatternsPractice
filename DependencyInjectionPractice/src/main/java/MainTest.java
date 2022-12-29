import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;

public class MainTest {

    public static void main(String[] args) {

        try {

//			Scanner scanner = new Scanner(System.in);
//			URL url = new URL(scanner.nextLine());

            // Now, main depends on concrete types, but SpellingChecker is no longer violating
            // the DIP; main can figure itself out however it wants :)
//			URLFetcher fetcher = new URLFetcher();
//			Dictionary dictionary = new Dictionary("dict.txt");
//			WordExtractor extractor = new WordExtractor();
//
//			SpellingChecker checker = new SpellingChecker(fetcher, extractor, dictionary);

            Injector injector = Guice.createInjector(new SimpleModuleTest());
            SpellingChecker checker = injector.getInstance(SpellingChecker.class);

            URL url = new URL(args[0]);
            SortedMap<String, Integer> mistakes = checker.check(url);

            System.out.println(mistakes);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
