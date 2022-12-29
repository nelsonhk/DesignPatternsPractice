package TextEditor;

public class ReplaceCommand implements Command {

    private IDocument document;
    private int replaceIndex;
    private int replaceDistance;
    private String replacementString;
    private String deletedString;

    public ReplaceCommand(IDocument document, int replaceIndex, int replaceDistance, String replacementString) {
        this.document = document;
        this.replaceIndex = replaceIndex;
        this.replaceDistance = replaceDistance;
        this.replacementString = replacementString;
    }

    @Override
    public void execute() {
        deletedString = document.delete(replaceIndex, replaceDistance);
        document.insert(replaceIndex, replacementString);
    }

    @Override
    public void undo() {
        document.delete(replaceIndex, replacementString.length());
        document.insert(replaceIndex, deletedString);
    }

    @Override
    public void redo() {
        execute();
    }
}
