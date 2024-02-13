package ContactManagementProgram;

import java.util.List;

public class AddressBook {
    private List<Contact> contactList;

    public AddressBook(List<Contact> contactList){
        this.contactList = contactList;
    }
    public void displayContacts(){
        if (!contactList.isEmpty()){
            for (Contact contact : contactList) {
                System.out.print("이름: " + contact.getName());
                System.out.print(", 전화번호: " + contact.getPhoneNumber());

                // BusinessContact의 경우 회사 정보 출력
                if (contact instanceof BusinessContact) {
                    System.out.println(", 회사: " + ((BusinessContact) contact).getCompany());
                } else{
                    System.out.println(", 관계: " + ((PersonalContact) contact).getRelationship());
                }
            }
        }else{
            System.out.println("연락처가 비어있습니다.");
        }
    }

    public void searchContact(String name){
        boolean temp = true;

        if(!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                if(contact.getName().equals(name)){
                    System.out.print("이름: " + contact.getName());
                    System.out.print(", 전화번호: " + contact.getPhoneNumber());

                    // BusinessContact의 경우 회사 정보 출력
                    if (contact instanceof BusinessContact) {
                        System.out.println(", 회사: " + ((BusinessContact) contact).getCompany());
                    } else{
                        System.out.println(", 관계: " + ((PersonalContact) contact).getRelationship());
                    }
                    temp = false;
                }
            }
            if(temp){
                System.out.println("찾으려는 사람이 연락처에 없습니다.");
            }
        } else{
            System.out.println("검색하려는 연락처가 비어있습니다.");
        }
    }
}
