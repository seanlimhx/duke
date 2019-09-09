import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskList() {};

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int getNumOfTasks() {
        return this.tasks.size();
    }

    public void printAllTasks() {
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }

    public ArrayList<Task> getArrayListTasks() {
        return this.tasks;
    }

    public Task getIndivTask(int index) {
        return this.tasks.get(index);
    }

    public void markAsDone(int index) {
        this.tasks.get(index).markAsDone();
    }

    public void deleteTask(int index) {
        this.tasks.remove(index);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

}
