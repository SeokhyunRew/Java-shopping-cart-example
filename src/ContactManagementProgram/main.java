package ContactManagementProgram;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String name;
        String phoneNumber;
        List<Contact> contactList = new ArrayList<>();

        do {
            // 메뉴 출력
            System.out.println("1. 비즈니스 연락처 추가");
            System.out.println("2. 개인 연락처 추가");
            System.out.println("3. 연락처 출력");
            System.out.println("4. 연락처 검색");
            System.out.println("5. 연락처 수정");
            System.out.println("6. 연락처 삭제");
            System.out.println("7. 종료");
            System.out.print("메뉴를 숫자 1~5중 입력해주세요: ");

            // 사용자 입력 받기
            choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            // 선택된 메뉴에 따라 처리
            switch (choice) {
                case 1:
                    System.out.println("추가하려는 비즈니스 연락처 정보를 입력하세요.");
                    // 추가 로직 구현
                    System.out.print("이름을 입력하세요: ");
                    name = scanner.nextLine();

                    System.out.print("전화번호를 입력하세요: ");
                    phoneNumber = scanner.nextLine();

                    System.out.print("회사를 입력하세요: ");
                    String company = scanner.nextLine();

                    // BusinessContact 객체 생성
                    BusinessContact businessContact = new BusinessContact(name, phoneNumber, company);
                    contactList.add(businessContact);
                    break;

                case 2:
                    System.out.println("추가하려는 개인 연락처 정보를 입력하세요.");
                    // 추가 로직 구현
                    System.out.print("이름을 입력하세요: ");
                    name = scanner.nextLine();

                    System.out.print("전화번호를 입력하세요: ");
                    phoneNumber = scanner.nextLine();

                    System.out.print("관계를 입력하세요: ");
                    String Relation = scanner.nextLine();

                    // BusinessContact 객체 생성
                    PersonalContact personalContact = new PersonalContact(name, phoneNumber, Relation);

                    contactList.add(personalContact);
                    break;
                case 3:
                    System.out.println("연락처 출력 기능을 선택했습니다, 모든 연락처를 보여드리겠습니다.");

                    AddressBook addressBookforDisplay = new AddressBook(contactList);
                    addressBookforDisplay.displayContacts();
                    // 출력 로직 구현
                    break;
                case 4:
                    System.out.println("검색하고싶은 연락처의 이름을 입력해주세요");
                    name = scanner.nextLine();

                    AddressBook addressBookforSearch = new AddressBook(contactList);
                    addressBookforSearch.searchContact(name);
                    // 검색 로직 구현
                    break;
                case 5:
                    System.out.println("수정할 연락처의 이름을 입력하세요(이름은 변경하지 못합니다)");
                    // 추가 로직 구현
                    System.out.print("이름을 입력하세요: ");
                    name = scanner.nextLine();

                    System.out.print("기존 번호에서 수정하려는 전화번호를 입력하세요: ");
                    phoneNumber = scanner.nextLine();

                    System.out.print("기존 정보에서 수정할 회사혹은 관계 내용을 입력하세요: ");
                    String keep = scanner.nextLine();

                    AddressBook addressBookforModify = new AddressBook(contactList);
                    if (addressBookforModify.modifyContact(name, phoneNumber, keep)){
                        System.out.println("변경한 " + name + "의 정보는 다음과 같습니다." );
                        addressBookforModify.searchContact(name);
                    }
                    break;

                case 6:
                    System.out.print("삭제할 연락처의 이름을 입력하세요: ");
                    name = scanner.nextLine();

                    AddressBook addressBookfordelete = new AddressBook(contactList);
                    if (addressBookfordelete.deleteContact(name)){
                        System.out.println(name + "을(를) 삭제한 후의 연락처는 다음과 같습니다." );
                        addressBookfordelete.displayContacts();
                    }
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

