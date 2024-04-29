
public class Teller extends Bank {
    private String tellerName;
    private String tellerID;
    public Teller (){

    }

    public String getTellerName() {
        return tellerName;
    }

    public String getTellerID() {
        return tellerID;
    }

    public void setTellerName(String tellerName) {
        this.tellerName = tellerName;
    }

    public void setTellerID(String tellerID) {
        this.tellerID = tellerID;
    }
    @Override
    public String toString(){
        return String.format("Teller Name: %s\nID: %s\n",tellerName,tellerID);

    }
}
