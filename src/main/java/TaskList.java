import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskList() {};

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public static int getNumOfTasks() {
        return tasks.size();
    }

    public void getAllTasks() {
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }

    public static Task getIndivTask(int index) {
        return tasks.get(index);
    }

    public static void markAsDone(int index) {
        tasks.get(index).markAsDone();
    }

    public static void deleteTask(int index) {
        tasks.remove(index);
    }

    public static void addTask(Task task) {
        tasks.add(task);
    }

}
