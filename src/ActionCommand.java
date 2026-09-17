// This class remembers the last added task so we can undo it
public class ActionCommand {
    private String actionType;
    private Task task;

    public ActionCommand(String actionType, Task task) {
        this.actionType = actionType;
        this.task = task;
    }

    public String getActionType() { return actionType; }
    public Task getTask() { return task; }
}
