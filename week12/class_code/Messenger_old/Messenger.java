package class_code.Messenger_old;

public class Messenger {
  public Messenger(String msg) {
    message = msg;
  }

  public void say() {
    System.out.print(message + "");
  }

  public void sayNtimes(int n) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      say();
      Thread.sleep(1);
    }
  }

  public void run() {
    try {
      sayNtimes(10);
    } catch (InterruptedException e) {
      return;
    }
  }

  private String message;
}
