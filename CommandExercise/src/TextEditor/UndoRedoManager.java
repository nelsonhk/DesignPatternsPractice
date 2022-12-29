package TextEditor;

import java.util.Stack;

public class UndoRedoManager {

    public UndoRedoManager() {}

    private Stack<Command> redoStack = new Stack();
    private Stack<Command> undoStack = new Stack();

    public void execute(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.empty();
    }

    public void undo() {
        if (canUndo()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (canRedo()) {
            Command command = redoStack.pop();
            command.redo();
            undoStack.push(command);
        }
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return redoStack.size() > 0;
    }

}
