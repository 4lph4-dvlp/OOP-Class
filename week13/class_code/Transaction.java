package week13.class_code;

class Account {
  private int balance;

  public Account() {
    balance = 0;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public void withdraw(int amount) {
    balance -= amount;
  }

  public int getBalance() {
    return balance;
  }
}

public class Transaction implements Runnable {
  private Account account;

  public Transaction(Account account) {
    this.account = account;
  }

  public void deposit(int amount) {
    account.deposit(amount);
    pretnedProcessing(1000);
  }

  public void withdraw(int amount) {
    account.withdraw(amount);
    pretnedProcessing(1000);
  }

  private void pretnedProcessing(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void run() {

  }
}
