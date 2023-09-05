import java.util.*;


class BankAccount{
    public double balance;
    
    public double getBalance(){
        return balance;
    }
    
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited Rs. " + amount +" to your bank acount!");
        }
        else{
            System.out.println("Invalid input, please try again");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && balance>=amount){
            balance-=amount;
            System.out.println("Rs. "+ amount +" have been withdrawn from your account!");
        }
        else{
            System.out.println("Unsufficient balance or invalid input!");
        }
    } 

}

class ATM{
    public BankAccount account;

    public void setBankAccount(BankAccount userAccount) {
        account = userAccount;
    }

    
    public void show(){
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run(){
        Scanner sc=new Scanner(System.in);
        int choice;

           do {
            show();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is Rs. " + account.balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
   



public class Main {
    public static void main(String args[]){
       BankAccount userAccount = new BankAccount();
       ATM atm = new ATM();
       atm.setBankAccount(userAccount); 
       atm.run();
       

    }
}