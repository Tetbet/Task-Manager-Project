import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        // Start Background Reminder Thread
        Thread reminderThread = new Thread(new ReminderThread(taskManager));
        reminderThread.setDaemon(true); // Dies when main thread dies
        reminderThread.start();

        System.out.println("=====================================");
        System.out.println("    Welcome to Smart Task Manager    ");
        System.out.println("=====================================");

        while (true) {
            System.out.println("\n1. Add Normal Task");
            System.out.println("2. Add Priority Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Complete a Task");
            System.out.println("5. Undo Last Add");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter task title: ");
                        String title = scanner.nextLine();
                        if (title.trim().isEmpty()) throw new InvalidInputException("Title cannot be empty!");
                        taskManager.addTask(title, "");
                        break;
                    case 2:
                        System.out.print("Enter task title: ");
                        String pTitle = scanner.nextLine();
                        if (pTitle.trim().isEmpty()) throw new InvalidInputException("Title cannot be empty!");
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = scanner.nextLine();
                        taskManager.addTask(pTitle, priority);
                        break;
                    case 3:
                        taskManager.displayTasks();
                        break;
                    case 4:
                        System.out.print("Enter Task ID to complete: ");
                        int id = scanner.nextInt();
                        taskManager.completeTask(id);
                        break;
                    case 5:
                        taskManager.undoLastAction();
                        break;
                    case 6:
                        System.out.println("Exiting System. Have a productive day!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear the bad input
            } catch (InvalidInputException | TaskNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
