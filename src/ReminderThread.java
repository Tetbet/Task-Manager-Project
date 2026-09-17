public class ReminderThread implements Runnable {
    private TaskManager taskManager;

    public ReminderThread(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Sleep for 30 seconds (simulating background checking)
                Thread.sleep(30000);
                
                int pendingTasks = 0;
                for (Task t : taskManager.getTasks()) {
                    if (!t.isCompleted()) {
                        pendingTasks++;
                    }
                }
                
                if (pendingTasks > 0) {
                    System.out.println("\n[BACKGROUND REMINDER]: You have " + pendingTasks + " pending task(s) to complete!");
                    System.out.print("Choose an option: "); // Reprint prompt so CLI doesn't look broken
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Reminder thread interrupted.");
        }
    }
}
