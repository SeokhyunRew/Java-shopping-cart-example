package ContactManagementProgram;

public class BusinessContact extends Contact {

    private String company;

    public BusinessContact(String name, String phoneNumber, String company){
        super(name, phoneNumber);
        this.company = company;
    }

    public String getCompany(){
        return this.company;
    }

    public void setContact(String name, String phoneNumber, String company){
        super.setContact(name, phoneNumber);
        this.company = company;
    }
}
