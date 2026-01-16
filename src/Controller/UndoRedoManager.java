package Controller;

/**
 * UndoRedoManager class - Manages undo/redo functionality using two stacks.
 * Implements the Command pattern for reversible operations.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class UndoRedoManager {
    /** Stack to store executed commands for undo operation */
    private MyStack<ActionCommand> undoStack = new MyStack<>();
    /** Stack to store undone commands for redo operation */
    private MyStack<ActionCommand> redoStack = new MyStack<>();

    /**
     * Executes a command and adds it to the undo stack.
     * Clears the redo stack as a new action invalidates previous redo operations.
     *
     * @param cmd The ActionCommand to execute
     */
    public void execute(ActionCommand cmd) {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
    }

    /**
     * Undoes the last executed command.
     * Moves the command from undo stack to redo stack.
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            ActionCommand cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    /**
     * Redoes the last undone command.
     * Moves the command from redo stack back to undo stack.
     */
    public void redo() {
        if (!redoStack.isEmpty()) {
            ActionCommand cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }
}