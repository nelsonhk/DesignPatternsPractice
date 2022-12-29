package TextEditor;

public class InsertCommand implements Command {

    private IDocument document;
    private int position;
    private String input;

    public InsertCommand(IDocument document, int position, String input) {
        this.document = document;
        this.position = position;
        this.input = input;
    }

    @Override
    public void execute() {
        document.insert(position, input);
    }

    @Override
    public void undo() {
        document.delete(position, input.length());
    }

    @Override
    public void redo() {
        execute();
    }
}
