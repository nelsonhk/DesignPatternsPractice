import java.io.*;

public class LineCount extends SuperSearch{

	private int _totalLineCount;
	
	public LineCount(String directory, String pattern, boolean recurse) {
		super(directory, pattern, recurse);
		_totalLineCount = 0;

	}

	@Override
	public void run() {
		super.run();
		System.out.println("TOTAL: " + _totalLineCount);
	}
	
	@Override
	public void searchDirectory(File dir) {
		super.searchDirectory(dir);
	}

	@Override
	public void searchFile(File file) {
		super.searchFile(file);
	}

	@Override
	void processLine(String line) {
		++_totalLineCount;
	}

	@Override
	void finallyClause(int curLineCount) {
		System.out.println(curLineCount + "  " + file);
	}
	
	public static void main(String[] args) {
		String directory = "";
		String pattern = "";
		boolean recurse = false;
		
		if (args.length == 2) {
			recurse = false;
			directory = args[0];
			pattern = args[1];
		}
		else if (args.length == 3 && args[0].equals("-r")) {
			recurse = true;
			directory = args[1];
			pattern = args[2];
		}
		else {
			usage();
			return;
		}
		
		LineCount lineCounter = new LineCount(directory, pattern, recurse);
		lineCounter.run();
	}

	private static void usage() {
		System.out.println("USAGE: java LineCount {-r} <dir> <file-pattern>");
	}

}
