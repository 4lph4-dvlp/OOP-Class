class Account {
    private String name;
    private int accountNum;
    private double balance;
    private final double RATE = 0.035;

    private static int nextAccountNum = 0;

    public Account(String name, int accountNum, double balance) {
        this.name = name;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public Account(String name, int accountNum) {
        this(name, accountNum, 0.0);
    }

    public Account(String name, double balance) {
        this(name, nextAccountNum++, balance);
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }

    public void addInterest() {
        balance += (balance * RATE);
    }

    public String toString() {
        return "name : " + name + "\taccount : " + accountNum + "\t\tbalance : " + balance + "won";
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct1 = new Account("Ted Murphy", 1000);
        Account acct2 = new Account("Jane Smith", 1001, 40.00);
        Account acct3 = new Account("Ed Demsey", 800.32);
        Account acct4 = new Account("Gildong", 10000.00);

        acct1.deposit(25.85);
        double smithBalance = acct2.deposit(500.00);
        System.out.println("Smith balance after deposit: " + smithBalance);
        System.out.println("Smith balance after withdrawal: " + acct2.withdraw(40.00));

        System.out.println();
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct3);
        System.out.println(acct4);

        acct1.addInterest();
        acct2.addInterest();
        acct3.addInterest();
        acct4.addInterest();

        System.out.println("WITH Interest------------------");
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct3);
        System.out.println(acct4);
    }
}
