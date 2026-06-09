package week13.lab;

class Spaghetti {
  private int amount;

  public Spaghetti(int amount) {
    this.amount = amount;
  }

  public void scoop() {
    amount--;
  }

  public boolean isEmpty() {
    return amount == 0;
  }
}

class Fork {
  private boolean locked;

  public Fork() {
    locked = false;
  }

  public synchronized void lock() {
    if (locked) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println("사용자에 의해 중단됨");
      }
    }
    locked = true;
  }

  public synchronized void unlock() {
    locked = false;
    notifyAll();
  }
}

public class Lab10_2_2 extends Thread {
  String name;
  Spaghetti bowl;
  Fork left, right;
  int scoops;

  public Lab10_2_2(String name, Spaghetti bowl, Fork left, Fork right) {
    this.name = name;
    this.bowl = bowl;
    this.left = left;
    this.right = right;
    scoops = 0;
  }

  public void getForks() {
    left.lock();
    right.lock();
  }

  public void releaseForks() {
    right.unlock();
    left.unlock();
  }

  public void eat() {
    getForks();
    bowl.scoop();
    scoops++;
    print();
    releaseForks();
  }

  public void print() {
    System.out.printf("%s: %d 포크 먹음%n", name, scoops);
  }

  public void finalPrint() {
    System.out.print("최종적으로... ");
    print();
  }

  public void run() {
    while (!bowl.isEmpty()) {
      eat();
    }
  }

  public static void main(String args[]) {
    final int NUM_OF_GUESTS = 2;
    final int BOWL_SIZE = 5000000;
    Lab10_2_2 guest[] = new Lab10_2_2[NUM_OF_GUESTS];
    Fork fork[] = new Fork[NUM_OF_GUESTS + 1];
    Spaghetti bowl[] = new Spaghetti[NUM_OF_GUESTS];
    String names[] = { "이황", "헤겔", "공자", "이이", "장자" };

    for (int i = 0; i < NUM_OF_GUESTS; ++i) {
      fork[i] = new Fork();
      bowl[i] = new Spaghetti(BOWL_SIZE);
    }
    fork[NUM_OF_GUESTS] = fork[0];

    for (int i = 0; i < NUM_OF_GUESTS; ++i) {
      int left = i;
      int right = i + 1;

      if (i == NUM_OF_GUESTS - 1) {
        right = i;
        left = i + 1;
      }

      guest[i] = new Lab10_2_2(names[i], bowl[i], fork[left], fork[right]);
      guest[i].start();
    }

    for (int i = 0; i < NUM_OF_GUESTS; ++i) {
      try {
        guest[i].join();
        guest[i].finalPrint();
      } catch (InterruptedException e) {
        System.out.println("Lab10_2_2.main(): 사용자에 의해 중단됨");
      }
    }
    System.out.println("*** 식사 끝 ***");
  }
}