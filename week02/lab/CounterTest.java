public class CounterTest {
  public static void main(String[] args) {
    Counter c = new Counter();
    System.out.println("계수값 : " + c.currentCount());

    c.incrementCount();
    System.out.println("계수값 : " + c.currentCount());

    c.incrementCount();
    System.out.println("계수값 : " + c.currentCount());

    c.decrementCounter();
    System.out.println("계수값 : " + c.currentCount());

    c.decrementCounter();
    System.out.println("계수값 : " + c.currentCount());

    c.decrementCounter();
    System.out.println("계수값 : " + c.currentCount());
  }
}

class Counter {
  private int count;

  public Counter() {
    count = 0;
  }

  public int currentCount() {
    return count;
  }

  public void incrementCount() {
    count = count + 1;
  }

  public void decrementCounter() {
    if(count > 0) {
      count = count - 1;
    }
  }

  public void reset() {
    count = 0;
  }
}
