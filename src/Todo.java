import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class Todo {

  static List<String> tasks;
  static Path myTodo;


  public static void main(String[] args) throws IOException {
    myTodo = Paths.get("todo.txt");
    tasks = Files.readAllLines(myTodo);

    System.out.println("$ todo\n" +
            "\n" +
            "Command Line Todo application\n" +
            "=============================\n" +
            "\n" +
            "Command line arguments:\n" +
            "    -l   Lists all the tasks\n" +
            "    -a   Adds a new task\n" +
            "    -r   Removes a task\n" +
            "    -c   Completes a task\n");


    if (args[0].equals("-l")) {
      listAllTheTasks();
    } else if (args[0].equals("-a")) {
      if (args[1].equals(null)) {
        System.out.println("there is nothing to add");
      } else {
        addsANewTask(args[1], myTodo, tasks);
      }
    } else if (args[0].equals("-r")) {
      removesATask(args[1], myTodo, tasks);
    } else if (args[0].equals("-c")) {
      ;
    } else {
    }

  }

  private static void CompletesATask() {

  }
  private static void removesATask(String arg, Path myTodo, List<String> tasks) throws IOException {
     int useThis = Integer.parseInt(arg);
    if (tasks.size() > 2) {
      tasks.remove(useThis);
    } else {
      System.out.println("there is nothing to delete");
    }
    Files.write(myTodo, tasks);
  }

  private static void addsANewTask(String arg, Path myTodo, List<String> tasks) throws IOException {

    tasks.add(arg);
    Files.write(myTodo, tasks);
  }

  private static void listAllTheTasks() {
    try {
      Paths.get("todo.txt");
      Files.readAllLines(myTodo);
      for (int i = 0; i < tasks.size(); i++) {
        if (tasks.size() == 0) {
          System.out.println("there is nothing to do today :)");
        } else {
          int temp = i + 1;
          System.out.println(temp + ". " + tasks.get(i));
        }
      }

    } catch (Exception e) {
      System.out.println("Could not read the file!");
    }
  }
}


