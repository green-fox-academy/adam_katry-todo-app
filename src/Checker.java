public class Checker {

  private String name;
  private boolean completed;

  public Checker(String name) {
    this.name = name;
  }

  public void complete() {
    this.completed = true;
  }


  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }

}
