import java.util.Scanner;


public class Menu {
    // Instances of the Scanner Class & Student Record Class.

    private Scanner scanner = new Scanner(System.in);
    private Teller bank = new Teller();

    // default constructor--don't need to write

    // method to display menu
    public void displayMenu() {
        while (true) {
            String selection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.print("Please make a selection:\n" +
                    "1) Access Account\n" +
                    "2) Open a New Account\n" +
                    "3) Close All Accounts\n" +
                    "4) Exit\n" +
                    ">> ");
            selection = scanner.nextLine();   // Get information from user
            // If-else-if  statements to
            if (selection.equals("1")) {
                accessAcount();
            } else if (selection.equals("2")) {
                openNewAccount();
            } else if (selection.equals("3")) {
                closeAllAccounts();
            } else if (selection.equals("4")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid entry");
            }
        }
    }

    private void accessAcount() {
        Account account;
        Customer customer;


        System.out.print("Enter your Pin: ");
        String pin = scanner.nextLine();
        customer = bank.getSingleCustomer(pin);
        if (customer == null) {
            System.out.println("Pin is Invalid");
            return;
        }
        System.out.println("*** Active Accounts***");
        System.out.println(customer.getAllAccount());

        System.out.print("Please enter the Account Number: ");
        int accountNum = Integer.parseInt(scanner.nextLine());
        account = customer.getSingleAccount(accountNum);
        if (account == null) {
            System.out.println("Account number is Invalid");
            return;
        }
        while (true) {
            System.out.print("Please make a selection:\n" +
                    "1) Make a Deposit\n" +
                    "2) Make a Withdraw\n" +
                    "3) See account Balance\n" +
                    "4) Close Account\n" +
                    "5) Exit\n" +
                    ">> ");
            String selection = scanner.nextLine();   // Get information from user
            // If-else-if  statements to
            if (selection.equals("1")) {
                System.out.println("Enter the deposit amount:");
                double amount = Double.parseDouble(scanner.nextLine());
                account.deposit(amount);
            } else if (selection.equals("2")) {
                System.out.println("Enter the withdrawl amount:");
                double amount = Double.parseDouble(scanner.nextLine());
                account.withdrawl(amount);
            } else if (selection.equals("3")) {
                System.out.printf("\n Account Number %d\n Account Balance %.2f", account.getAccountNumber(), account.getBalance());
            } else if (selection.equals("4")) {
                System.out.printf("\n Account number %d closed,\n", account.getAccountNumber());
            } else if (selection.equals("5")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid entry");
            }
        }
    }

    private Customer createNewCustomer() {
        String firstName, lastName, pin;
        System.out.println("Please enter your first name:");
        firstName = scanner.nextLine();
        System.out.println("Please enter your last name:");
        lastName = scanner.nextLine();
        System.out.println("Please enter a four digit pin:");
        pin = scanner.nextLine();
        double deposit = Double.parseDouble(scanner.nextLine());
        Customer customer = new Customer(firstName, lastName, pin);
        bank.addCustomer(customer);
        return customer;
    }

    private void openNewAccount() {
        String newCustomer;
        Customer customer;
        Account account;
        System.out.println("Are you are new Customer?\n" + "1) Yes\n" + "2) No\n");
        newCustomer = scanner.nextLine();
        if (newCustomer.equals("1")) {
            customer = createNewCustomer();

        } else {
            System.out.println("Please enter pin:");
            customer = bank.getSingleCustomer(scanner.nextLine());
            if (customer == null) {
                System.out.println("Pin is invalid");
                return;
            }
        }
        System.out.println("Please enter depsoit amount: ");
        double deposit = Double.parseDouble(scanner.nextLine());
        bank.addCustomer(customer);
        account = new Account(deposit);
        System.out.printf("\n New Account opened: %s\n", account.getAccountNumber());
    }


    private void closeAllAccounts() {
        Customer customer;
        Account account;
        String pin;


        System.out.print("Enter the your pin: ");
        pin = scanner.nextLine();
        customer = bank.getSingleCustomer(pin);

        if (customer == null) {
            System.out.println("Pin is invalid.");
        }
        bank.removeCustomer(customer);
        System.out.println("You have been removed");

    }
}



