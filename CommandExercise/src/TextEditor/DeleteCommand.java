package TextEditor;

public class DeleteCommand implements Command {

    private IDocument document;
    private int deletionIndex;
    private int deletionDistance;
    private String deletedString;

    public DeleteCommand(IDocument document, int deletionIndex, int deletionDistance) {
        this.document = document;
        this.deletionIndex = deletionIndex;
        this.deletionDistance = deletionDistance;
    }

    @Override
    public void execute() {
        deletedString = document.delete(deletionIndex, deletionDistance);
    }

    @Override
    public void undo() {
        document.insert(deletionIndex, deletedString);
    }

    @Override
    public void redo() {
        execute();
    }

    public String getDeletedString() {
        return deletedString;
    }
}
