package Controller;
import java.util.Stack;

// Manager
public class UndoRedoManager {
    private Stack<ActionCommand> undoStack = new Stack<>();
    private Stack<ActionCommand> redoStack = new Stack<>();

    public void execute(ActionCommand cmd) {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear(); // clear redo after new action
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            ActionCommand cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            ActionCommand cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }
}