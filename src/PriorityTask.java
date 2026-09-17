public class PriorityTask extends Task {
    private String priorityLevel; // High, Medium, Low

    public PriorityTask(int id, String title, String priorityLevel) {
        super(id, title);
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        return super.toString() + " | Priority: " + priorityLevel;
    }
}
