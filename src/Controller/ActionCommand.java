package Controller;

import java.util.Stack;

// Lambda-based unified command
public class ActionCommand {
    private Runnable executeAction;
    private Runnable undoAction;

    public ActionCommand(Runnable executeAction, Runnable undoAction) {
        this.executeAction = executeAction;
        this.undoAction = undoAction;
    }

    public void execute() { executeAction.run(); }
    public void undo() { undoAction.run(); }
}


