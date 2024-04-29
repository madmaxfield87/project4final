import java.util.LinkedList;


    public class Customer {
        //Instance variable
        private String firstName, lastName,pin;
        private LinkedList<Account> accountArrayList = new LinkedList<>();

        public Customer(String firstName, String lastName, String pin){
            this.firstName = firstName;
            this.lastName = lastName;
            this.pin=pin;
        }

        public String getPin() {
            return pin;
        }

        public void addAccount(Account account){
            accountArrayList.add(account);
        }
        public void removeAccount(Account account){
            accountArrayList.remove(account);
        }
        public Account getSingleAccount(int accountNumber){
            Account foundAccount = null;
            for(Account account: accountArrayList){
                if(account.getAccountNumber()== accountNumber){
                    foundAccount = account;
                    break;
                }
            }
            return foundAccount;
        }
        public String getAllAccount(){
            String allAccounts = "";
            for(Account account: accountArrayList){
                allAccounts+= account.toString() + "\n";
            }
            return allAccounts;
        }
        @Override
        public String toString(){
            return String.format("First Name: %s\nLast Name: %s\nPin: %s\n",firstName,lastName,pin);

        }

    }


