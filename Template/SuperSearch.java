import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SuperSearch {

    private String _directory;
    private String _filePattern;
    private boolean _recurse;
    private Matcher _fileMatcher;
    public File file;

    public SuperSearch(String directory, String pattern, boolean recurse) {
        _directory = directory;
        _filePattern = pattern;
        _recurse = recurse;
        _fileMatcher = Pattern.compile(_filePattern).matcher("");
    }

    public void run() {
        searchDirectory(new File(_directory));
    }

    public void searchDirectory(File dir) {

        if (!dir.isDirectory()) {
            nonDir(dir);
            return;
        }

        if (!dir.canRead()) {
            unreadableDir(dir);
            return;
        }

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    searchFile(file);
                }
                else {
                    System.out.println("File " + file + " is unreadable");
                }
            }
        }

        if (_recurse) {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    searchDirectory(file);
                }
            }
        }
    }

    public void searchFile(File file) {
        String fileName = getFileName(file);
        _fileMatcher.reset(fileName);

        this.file = file;

        if (_fileMatcher.find()) {
            try {

                Reader reader = new BufferedReader(new FileReader(file));
                int curLineCount = 0;
                try {
                    Scanner input = new Scanner(reader);
                    while (input.hasNextLine()) {
                        String line = input.nextLine();

                        ++curLineCount;
                        processLine(line);
                    }
                }
                finally {
//                    System.out.println(curLineCount + "  " + file);
                    finallyClause(curLineCount);
                    reader.close();
                }
            }
            catch (IOException e) {
                unreadableFile(file);
            }
        }
    }

    abstract void processLine(String line);

    abstract void finallyClause(int curLineCount);

    private String getFileName(File file) {
        try {
            return file.getCanonicalPath();
        }
        catch (IOException e) {
            return "";
        }
    }

    private void nonDir(File dir) {
        System.out.println(dir + " is not a directory");
    }

    private void unreadableDir(File dir) {
        System.out.println("Directory " + dir + " is unreadable");
    }

    private void unreadableFile(File file) {
        System.out.println("File " + file + " is unreadable");
    }

}
