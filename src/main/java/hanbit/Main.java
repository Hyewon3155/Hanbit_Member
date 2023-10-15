package hanbit;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PeopleDao peopleDao = new PeopleDao();

        System.out.println("1.조회 2. 수정 3. 삭제 4. 등록");
        int answer = scanner.nextInt();

        switch (answer) {
            case 1:
                System.out.print("사용자의 아이디를 입력해주세요");
                String userId = scanner.next();
                PeopleSelectService peopleSelectService = new PeopleSelectService(peopleDao);
                People selectedPeople = peopleSelectService.select(userId);
                if (selectedPeople != null) {
                    System.out.println(selectedPeople);
                } else {
                    System.out.println("해당 아이디의 사용자가 존재하지 않습니다.");
                }
                break;

            case 2:
                System.out.print("사용자의 아이디를 입력해주세요");
                String userId2 = scanner.next();
                People foundPeople = peopleDao.select(userId2);

                while (true) {
                    System.out.println("수정하고 싶은 것을 고르시오 0.중지 1.아이디 2.비밀번호 3. 전화번호 4. 이메일");
                    int selectNumber = scanner.nextInt();
                    if (selectNumber == 0) {
                        break;
                    }

                    PeopleModifyService peopleModifyService = new PeopleModifyService(peopleDao);
                    LocalTime now = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
                    String updateDate = now.format(formatter);

                    switch (selectNumber) {
                        case 1:
                            System.out.print("아이디를 입력해주세요");
                            String newId = scanner.next();
                            peopleModifyService.modify(new People(newId, foundPeople.getsPw(), foundPeople.getsPhoneNum(), foundPeople.getsEmail(), foundPeople.getsRegDate(), updateDate));
                            break;

                        case 2:
                            System.out.print("비밀번호를 입력해주세요");
                            String newPw = scanner.next();
                            peopleModifyService.modify(new People(foundPeople.getsId(), newPw, foundPeople.getsPhoneNum(), foundPeople.getsEmail(), foundPeople.getsRegDate(), updateDate));
                            break;

                        case 3:
                            System.out.print("전화번호를 입력해주세요");
                            String newPhone = scanner.next();
                            peopleModifyService.modify(new People(foundPeople.getsId(), foundPeople.getsPw(), newPhone, foundPeople.getsEmail(), foundPeople.getsRegDate(), updateDate));
                            break;

                        case 4:
                            System.out.print("이메일을 입력해주세요");
                            String newEmail = scanner.next();
                            peopleModifyService.modify(new People(foundPeople.getsId(), foundPeople.getsPw(), foundPeople.getsPhoneNum(), newEmail, foundPeople.getsRegDate(), updateDate));
                            break;
                    }
                }
                break;

            case 3:
                System.out.print("아이디를 입력해주세요:");
                String deleteId = scanner.next();
                PeopleDeleteService peopleDeleteService = new PeopleDeleteService(peopleDao);
                peopleDeleteService.delete(deleteId);
                System.out.println("사용자 정보를 삭제했습니다.");
                break;

            case 4:
                System.out.print("아이디를 입력해주세요:");
                String newId = scanner.next();
                System.out.print("비밀번호를 입력해주세요:");
                String newPw = scanner.next();
                System.out.print("전화번호를 입력해주세요:");
                String newPhoneNum = scanner.next();
                System.out.print("이메일을 입력해주세요:");
                String newEmail = scanner.next();
                scanner.close();
                LocalTime now = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
                String regDate = now.format(formatter);

                PeopleRegisterService peopleRegisterService = new PeopleRegisterService(peopleDao);
                peopleRegisterService.register(new People(newId, newPw, newPhoneNum, newEmail, regDate, null));

                PeopleAllSelectService allSelectService = new PeopleAllSelectService(peopleDao);
                PrintPeopleInformationService printPeopleInformationService = new PrintPeopleInformationService(allSelectService);
                printPeopleInformationService.printPeopleInfo();
                break;
        }
    }
}
