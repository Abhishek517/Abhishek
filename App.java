import java.util.Scanner;
class Account
{
    
}
class Bank extends Account
{
    private String accountNum;
    private double balance;
    public Bank(String acctNum, double initialBalance)
    {
        accountNum = acctNum;
        balance = initialBalance;
    }
    public void deposit(double amount)
    {
        double newBalance = balance + amount;
        balance = newBalance;			
    }
    public void withdraw(double amount)	
    {
        double newBalance = balance - amount;
        balance = newBalance;
    }
    public String getAccount()	
    {
        return accountNum;
    }
    public double getBalance()	
    {
        return balance;	
    }
    public void transferFundsA(Bank destination, double amount)
    {
        destination.balance = destination.balance + amount;
        this.balance = this.balance - amount;
    }
    public void transferFundsB(Bank destination, double amount)
    {
        destination.deposit(amount);	
        this.withdraw(amount);       
    }
}
public class App
{
    public static void main(String args[] )
    { 
        Bank first = new Bank("1111111", 20000);
        Bank second = new Bank("2222222", 30000);
        System.out.printf("Account #%s has initial balance of %.2f%n",
                first.getAccount(), first.getBalance());

        System.out.printf("Account #%s has initial balance of %.2f%n",
                second.getAccount(), second.getBalance());
        first.transferFundsA(second, 5000);
        System.out.println("\nAfter \"first.transferFunds(second, 5000)\" ...");
        System.out.printf("Account #%s has new balance of %.2f%n",
                first.getAccount(), first.getBalance());

        System.out.printf("Account #%s has new balance of %.2f%n",
                second.getAccount(), second.getBalance());
        second.transferFundsB(first, 10000);
        System.out.println("\nAfter \"second.transferFunds(first, 10000)\" ...");
        System.out.printf("Account #%s has new balance of %.2f%n",
                first.getAccount(), first.getBalance());
        System.out.printf("Account #%s has new balance of %.2f%n",
                second.getAccount(), second.getBalance());
        int balance = 5000, withdraw, deposit;
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.println("Automated Teller Machine");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform:");
            int n = s.nextInt();
            switch(n)
            {
                case 1:
                System.out.print("Enter money to be withdrawn:");
                withdraw = s.nextInt();
                if(balance >= withdraw)
                {
                    balance = balance - withdraw;
                    System.out.println("Please collect your money");
                }
                else
                {
                    System.out.println("Insufficient Balance");
                }
                System.out.println("");
                break;
                case 2:
                System.out.print("Enter money to be deposited:");
                deposit = s.nextInt();
                balance = balance + deposit;
                System.out.println("Your Money has been successfully depsited");
                System.out.println("");
                break;
                case 3:
                System.out.println("Balance : "+balance);
                System.out.println("");
                break;
                case 4:
                System.exit(0);
            }
        }
    }
}