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
                    break;
                }
            }
            if(temp){
                System.out.println("찾으려는 사람이 연락처에 없습니다.");
            }
        } else{
            System.out.println("검색하려는 연락처가 비어있습니다.");
        }
    }

    public boolean modifyContact(String name, String phoneNumber, String keep){
        boolean temp = true;

        if(!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                if(contact.getName().equals(name)){
                    // BusinessContact의 경우 회사 정보 출력
                    if (contact instanceof BusinessContact) {
                        ((BusinessContact) contact).setContact(name,phoneNumber,keep);
                    } else{
                        ((PersonalContact) contact).setContact(name,phoneNumber,keep);
                    }
                    temp = false;
                    break;
                }
            }
            if(temp){
                System.out.println("수정하려는 연락처가 존재하지 않습니다.");
                return false;
            }
        } else{
            System.out.println("검색하려는 연락처가 비어있습니다.");
            return false;
        }
        return true;
    }

    public boolean deleteContact(String name) {
        boolean temp = true;

        if(!contactList.isEmpty()) {
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getName().equals(name)) {
                    contactList.remove(i);
                    temp = false;
                    break; // 제거했으면 반복문을 종료할 수 있습니다.
                }
            }
            if(temp){
                System.out.println("삭제하려는 연락처가 존재하지 않습니다.");
                return false;
            }
        } else{
            System.out.println("삭제하려는 연락처가 비어있습니다.");
            return false;
        }
        return true;
    }
}
