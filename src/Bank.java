import java.util.ArrayList;

public class Bank {
    //
    private ArrayList<Customer> customerArrayList = new ArrayList<>();


    //add
    //remove
    //get single customer
    //ger all customers


    public void addCustomer(Customer customer){
        customerArrayList.add(customer);
    }
    public void removeCustomer(Customer customer){
        customerArrayList.remove(customer);
    }
    public Customer getSingleCustomer(String pin){
        Customer foundCustomer = null;
        for(Customer customer: customerArrayList){
            if(customer.getPin().equals(pin) ){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public String getAllCustomer(){
        String allCustomer = "";
        for(Customer customer: customerArrayList){
            allCustomer += customer.toString() + "\n";
        }
        return allCustomer;
    }
}

