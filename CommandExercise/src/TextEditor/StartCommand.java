package TextEditor;

public class StartCommand implements Command {

    private IDocument document;
    private String previousDocument;

    public StartCommand(IDocument document) {
        this.document = document;
    }

    @Override
    public void execute() {
        previousDocument = document.sequence().toString();
        document.clear();
    }

    @Override
    public void undo() {
        document.insert(0, previousDocument);
    }

    @Override
    public void redo() {
        execute();
    }

}
