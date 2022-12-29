import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Dictionary implements IDictionary {

	private Set<String> words;

    @Inject
	public Dictionary(@Named("DictionaryFilePath") String fileName) throws IOException {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            words = new TreeSet<>();
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                words.add(word);
            }
        }
	}

	public boolean isValidWord(String word) {
		return words.contains(word);
	}
}

