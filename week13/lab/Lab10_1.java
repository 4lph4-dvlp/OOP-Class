package week13.lab;

import java.util.Random;

public class Lab10_1 {
  public static void main(String[] args) {
    Dish d = new Dish();
    Producer cheezeProducer = new Producer(Hamburger.CHEEZE, d);
    Producer fishProducer = new Producer(Hamburger.FISH, d);
    Consumer c1 = new Consumer("철수", d);
    Consumer c2 = new Consumer("민수", d);

    cheezeProducer.start();
    fishProducer.start();
    c1.start();
    c2.start();
  }
}

class Hamburger {
  public static final int CHEEZE = 0;
  public static final int FISH = 1;
  static int serial_number = 0;

  public int kind;
  private int id;

  Hamburger(int kind) {
    this.kind = kind;
    this.id = serial_number++;
  }

  public String toString() {
    if (kind == CHEEZE)
      return ("치즈버거" + id);
    else
      return ("피시버거" + id);
  }
}

class Producer extends Thread {
  int kind;
  Dish dish;
  Random r = new Random();

  Producer(int kind, Dish d) {
    this.kind = kind;
    this.dish = d;
  }

  private Hamburger produce() {
    Hamburger h = new Hamburger(kind);
    dish.add(h);
    return h;
  }

  public void run() {
    while (true) {
      try {
        sleep(r.nextInt(5000));
      } catch (Exception e) {
      }
      Hamburger h = produce();
    }
  }
}

class Consumer extends Thread {
  String name;
  Dish dish;
  Random r = new Random();

  Consumer(String name, Dish d) {
    this.name = name;
    this.dish = d;
  }

  private Hamburger consume() {
    return (dish.get());
  }

  public void run() {
    while (true) {
      try {
        sleep(r.nextInt(5000));
      } catch (Exception e) {
      }
      Hamburger h = consume();
    }
  }
}

class Dish {
  static final int DishSize = 4;
  static final int CheezeMax = 2;
  static final int FishMax = DishSize - CheezeMax;

  int cheezenum = 0;
  int fishnum = 0;
  Hamburger[] dish = new Hamburger[DishSize];
  int fresh = -1;
  int old = -1;

  public synchronized void add(Hamburger h) {
    try {
      while ((h.kind == Hamburger.CHEEZE && cheezenum >= CheezeMax) ||
          (h.kind == Hamburger.FISH && fishnum >= FishMax)) {
        wait();
      }

      if (old == -1)
        old = 0;

      fresh = (fresh + 1) % DishSize;
      dish[fresh] = h;

      if (h.kind == Hamburger.CHEEZE) {
        cheezenum++;
      } else {
        fishnum++;
      }

      System.out.println(h + " is added to the dish: " + this.toString());

      notifyAll();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized Hamburger get() {
    Hamburger h = null;
    try {
      while (cheezenum == 0 && fishnum == 0) {
        wait();
      }

      h = dish[old];
      dish[old] = null;

      if (h.kind == Hamburger.CHEEZE) {
        cheezenum--;
      } else {
        fishnum--;
      }

      System.out.println(h + " is consumed from the dish: " + this.toString());

      old = (old + 1) % DishSize;

      notifyAll();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return h;
  }

  public String toString() {
    return ("[" + dish[0] + "," + dish[1] + "," + dish[2] + "," + dish[3] + "]");
  }
}