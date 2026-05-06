class Account {
  static int accountNumBuf = 0;

  private final double INTEREST_RATE = 0.035;
  private String owner;
  private int accountNum;
  private double balance;

  public int getAccountNum() {return accountNum;}
  public String getOwner() {return owner;}
  public String toString() {
    return ("name : " + owner + "\taccount : " + accountNum + "\tbalance : " + balance);
  }
  
  public Account(String owner) {
    this.owner = owner;
    this.balance = 0;
    this.accountNum = Account.accountNumBuf;
    Account.accountNumBuf += 1;
  }
  public Account(String owner, double balance) {
    this.owner = owner;
    this.balance = balance;
    this.accountNum = Account.accountNumBuf;
    Account.accountNumBuf += 1;
  }
  public Account(String owner, int accountNum) {
    this.owner = owner;
    this.balance = 0;
    this.accountNum = accountNum;
  }
  public Account(String owner, int accountNum, double balance){
    this.owner = owner;
    this.accountNum = accountNum;
    this.balance = balance;
  }

  public double withdraw(double amount) {
    if(balance < amount) {
      System.out.println("잔액이 부족합니다.");
    } else {
      balance -= amount;
    }
    return balance;
  }

  public double deposit(double amount) {
    balance += amount;
    return balance;
  }

  public double addInterest() {
    balance += (balance * INTEREST_RATE);
    return balance;
  }
}

public class Lab2_3 {
  public static void main(String[] args) {
    Account acct1 = new Account ("Ted Murphy", 1000);
    Account acct2 = new Account ("Jane Smith", 1001, 40.00);
    Account acct3 = new Account ("Ed Demsey", 800.32);
    Account acct4 = new Account ("Gildong", 10000.00);

    acct1.deposit (25.85);
    double smithBalance = acct2.deposit (500.00);
    System.out.println ("Smith balance after deposit: "   +   smithBalance);
    System.out.println ("Smith balance after withdrawal: " + acct2.withdraw(40.00));

    System.out.println ();
    System.out.println (acct1);
    System.out.println (acct2);
    System.out.println (acct3);
    System.out.println (acct4);


    acct1.addInterest();
    acct2.addInterest();
    acct3.addInterest();
    acct4.addInterest();

    System.out.println ("WITH Interest------------------");
    System.out.println (acct1);
    System.out.println (acct2);
    System.out.println (acct3);
    System.out.println (acct4);

  }
}
