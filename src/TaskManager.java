import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TaskManager {
    private List<Task> tasks;
    private Stack<ActionCommand> undoStack;
    private int nextId;

    public TaskManager() {
        tasks = new ArrayList<>();
        undoStack = new Stack<>();
        nextId = 1;
    }

    public void addTask(String title, String priority) {
        Task newTask;
        if (priority.isEmpty()) {
            newTask = new Task(nextId++, title);
        } else {
            newTask = new PriorityTask(nextId++, title, priority);
        }
        tasks.add(newTask);
        undoStack.push(new ActionCommand("ADD", newTask));
        System.out.println("Task added successfully!");
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\n--- Your Tasks ---");
        for (Task t : tasks) {
            System.out.println(t.toString());
        }
        System.out.println("------------------");
    }

    public void completeTask(int id) throws TaskNotFoundException {
        for (Task t : tasks) {
            if (t.getId() == id) {
                if (t.isCompleted()) {
                    System.out.println("Task is already completed.");
                    return;
                }
                t.markCompleted();
                System.out.println("Task marked as completed!");
                return;
            }
        }
        throw new TaskNotFoundException("Task with ID " + id + " not found!");
    }

    public void undoLastAction() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        ActionCommand lastAction = undoStack.pop();
        if (lastAction.getActionType().equals("ADD")) {
            tasks.remove(lastAction.getTask());
            System.out.println("Undo successful: Removed task '" + lastAction.getTask().getTitle() + "'");
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
