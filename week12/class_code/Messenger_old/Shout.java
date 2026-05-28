package class_code.Messenger_old;

public class Shout {
  public static void main(String[] args) {
    Messenger large = new Messenger("HA");
    Messenger small = new Messenger("ha");

    large.run();
    small.run();
  }
}
