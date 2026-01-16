package Controller;

import java.util.Stack;

/**
 * ActionCommand class - Encapsulates undo/redo operations using lambda functions.
 * This class implements the Command design pattern with Runnable-based actions.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class ActionCommand {
    /** Lambda function to execute the action */
    private Runnable executeAction;
    /** Lambda function to undo the action */
    private Runnable undoAction;

    /**
     * Constructs an ActionCommand with execution and undo operations.
     *
     * @param executeAction The runnable function to execute the action
     * @param undoAction The runnable function to undo the action
     */
    public ActionCommand(Runnable executeAction, Runnable undoAction) {
        this.executeAction = executeAction;
        this.undoAction = undoAction;
    }

    /**
     * Executes the action by running the executeAction lambda.
     */
    public void execute() { 
        executeAction.run(); 
    }

    /**
     * Undoes the action by running the undoAction lambda.
     */
    public void undo() { 
        undoAction.run(); 
    }
}


