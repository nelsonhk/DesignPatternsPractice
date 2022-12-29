import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FileSearch extends SuperSearch {

	private Matcher _searchMatcher; //subclass
	private int _totalMatches; //subclass
	private int currMatches;


	public FileSearch(String dirName, String filePattern, String searchPattern, boolean recurse) {
		super(dirName, filePattern, recurse);
		_searchMatcher = Pattern.compile(searchPattern).matcher("");
		_totalMatches = 0;
	}

	@Override
	public void run() {
		super.run();
		System.out.println("");
		System.out.println("TOTAL MATCHES: " + _totalMatches);
	}

	@Override
	public void searchDirectory(File dir) {
		super.searchDirectory(dir);
	}

	@Override
	public void searchFile(File file) {
		currMatches = 0;

		super.searchFile(file);
	}

	@Override
	void processLine(String line) {

		_searchMatcher.reset(line);
		if (_searchMatcher.find()) {
			if (++currMatches == 1) {
				System.out.println("");
				System.out.println("FILE: " + file);
			}

			System.out.println(line);
			++_totalMatches;
		}
	}

	@Override
	void finallyClause(int curLineCount) {
		if (currMatches > 0) {
			System.out.println("MATCHES: " + currMatches);
		}
	}
	
	public static void main(String[] args) {
		
		String dirName = "";
		String filePattern = "";
		String searchPattern = "";
		boolean recurse = false;
		
		if (args.length == 3) {
			recurse = false;
			dirName = args[0];
			filePattern = args[1];
			searchPattern = args[2];
		}
		else if (args.length == 4 && args[0].equals("-r")) {
			recurse = true;
			dirName = args[1];
			filePattern = args[2];
			searchPattern = args[3];
		}
		else {
			usage();
			return;
		}
		
		FileSearch fileSearch = new FileSearch(dirName, filePattern, searchPattern, recurse);
		fileSearch.run();
	}

	private static void usage() {
		System.out.println("USAGE: java FileSearch {-r} <dir> <file-pattern> <search-pattern>");
	}

}
