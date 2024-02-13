package ContactManagementProgram;

public class PersonalContact extends Contact {

    private String relationship;
    public PersonalContact(String name, String phoneNumber, String relationship){
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    public String getRelationship(){
        return this.relationship;
    }

    public void setContact(String name, String phoneNumber, String relationship){
        super.setContact(name, phoneNumber);
        this.relationship = relationship;
    }
}
