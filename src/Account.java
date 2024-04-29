
    public class Account {
        // instant variables
        // access modifier data type data name;
        private double balance;
        private int accountNumber;
        private static int numberOfAccounts=1000 ;
        // constructer
        // consturcter is going to intiazlize the instant variable to whatever is passed in, or if nothing is passed in at all
        public Account(double IntitalDeposit){
            this.balance = IntitalDeposit;
            this.accountNumber = numberOfAccounts++;
        }

        public double getBalance() {
            return balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public void deposit(double Amount){
            balance += Amount;
            System.out.println("The Amount depsoited:" + Amount);
            System.out.println("Your updated Balance is " + balance);
        }
        public void withdrawl(double Amount){
            if(Amount> balance){
                System.out.println("You have Insufiucent Funds");
            }else{
                balance -= Amount;
                System.out.println("The Amount Withdrawn:" + Amount);
                System.out.println("Your updated Balance is " + balance);

            }
        }
        @Override
        public String toString(){
            return String.format("Account Number: %d\nBalance: %.2f\n",accountNumber,balance);

        }


    }


