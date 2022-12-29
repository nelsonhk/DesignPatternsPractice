package TextEditor;

public class OpenCommand implements Command {

    private IDocument document;
    private String previousDocString;
    private String fileName;

    public OpenCommand(IDocument document, String fileName) {
        this.document = document;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        previousDocString = document.sequence().toString();
        document.open(fileName);
    }

    @Override
    public void undo() {
        document.clear();
        document.insert(0, previousDocString);
    }

    @Override
    public void redo() {
        execute();
    }
}
