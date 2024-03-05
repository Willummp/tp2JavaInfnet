import java.time.LocalDate;
import java.util.*;

public class TasksManager {
    private List<Tasks> tasks;
    private Map<LocalDate, Integer> pointsMap;
    private int points;

    public TasksManager() {
        this.tasks = new ArrayList<>();
        this.pointsMap = new HashMap<>();
        this.points = 0;
    }

    public void viewTasks() {
        System.out.println("------ Tasks ------");
        for (int i = 0; i < tasks.size(); i++) {
            Tasks task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getTitle() + " - " + (task.isCompleted() ? "Completed" : "Not Completed"));
        }
    }

    public void addTasks(String title, String description) {
        tasks.add(new Tasks(title, description));
    }

    public void viewTasksDetails(int index) {
        Tasks task = tasks.get(index - 1);
        System.out.println("Title: " + task.getTitle());
        System.out.println("Description: " + task.getDescription());
        System.out.println("Creation Date: " + task.getCreationDate());
        System.out.println("Completion Date: " + (task.isCompleted() ? task.getCompletionDate() : "Not Completed"));
    }

    public void markTasksAsCompleted(int index) {
        Tasks task = tasks.get(index - 1);
        if (!task.isCompleted()) {
            task.markAsCompleted();
            updatePoints();
        }
    }

    private void updatePoints() {
        LocalDate today = LocalDate.now();
        points += 1;
        pointsMap.put(today, pointsMap.getOrDefault(today, 0) + 1);
        if (pointsMap.getOrDefault(today, 0) >= 3) {
            points += 1;
        }
        if (pointsMap.getOrDefault(today, 0) >= 5) {
            points += 2;
        }
    }

    public void losePoint() {
        points -= 1;
    }

    public int getPoints() {
        return points;
    }

    public static void main(String[] args) {
        TasksManager taskManager = new TasksManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------ Tasks Manager Menu ------");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Tasks");
            System.out.println("3. View Tasks Details");
            System.out.println("4. Mark Tasks as Completed");
            System.out.println("5. View Points");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    taskManager.viewTasks();
                    break;
                case 2:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTasks(title, description);
                    break;
                case 3:
                    System.out.print("Enter task index: ");
                    int index = scanner.nextInt();
                    taskManager.viewTasksDetails(index);
                    break;
                case 4:
                    System.out.print("Enter task index: ");
                    int taskIndex = scanner.nextInt();
                    taskManager.markTasksAsCompleted(taskIndex);
                    break;
                case 5:
                    System.out.println("Points: " + taskManager.getPoints());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }

            if (taskManager.getPoints() <= 0) {
                System.out.println("You lost 1 point for not completing a task today.");
                taskManager.losePoint();
            }
        }
    }
}