package class_code;

class Account {
  private int balance;

  public Account() {
    balance = 0;
  }

  public synchronized void deposit(int amount) {
    int temp = balance;
    try {
      Thread.sleep(10);
    } catch (Exception e) {
    }
    balance = temp + amount;
  }

  public synchronized void withdraw(int amount) {
    balance -= amount;
  }

  public int balance() {
    return balance;
  }
}

public class Transaction implements Runnable {
  private Account acc;

  public Transaction(Account account) {
    acc = account;
  }

  public void deposit(int amount) {
    acc.deposit(amount);
    pretendProcessing(0);
  }

  protected void pretendProcessing(int delayInMillis) {
    try {
      Thread.sleep(delayInMillis);
    } catch (InterruptedException e) {
      System.out.println("사용자에 의해 중단됨");
    }
  }

  public void run() {
    deposit(10000);
  }

  public static void main(String args[]) {
    Account account = new Account();
    System.out.printf("예금 전 잔액 = %d%n", account.balance());
    Transaction tr = new Transaction(account);
    Thread thread1 = new Thread(tr);
    thread1.start();
    tr.run();
    try {
      thread1.join();
    } catch (InterruptedException e) {
      System.out.println("사용자에 의해 중단됨");
    }
    System.out.printf("예금 후 잔액 = %d%n", account.balance());
  }
}
