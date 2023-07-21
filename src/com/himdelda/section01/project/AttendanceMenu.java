package com.himdelda.section01.project;

import java.util.Scanner;

public class AttendanceMenu {
    private StudentInformation infor = new StudentInformation();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu(){

        mainMenu:
        while(true){
            System.out.println("========== 메뉴 ==========");
            System.out.println("1. 학생 정보 추가");
            System.out.println("2. 출석부 조회");
            System.out.println("3. 정렬하여 조회");
            System.out.println("4. 학생명으로 검색");
            System.out.println("5. 학년으로 검색");
            System.out.println("6. 학생 정보 수정");
            System.out.println("7. 학생 정보 삭제");
            System.out.println("0. 프로그램 종료");

            System.out.print("어떤것을 도와드릴까요? : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    addInformation();
                    break;
                case 2:
                    selecAttendance();
                    break;
                case 3:
                    sortMenu();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    searchGrade();
                    break;
                case 6:
                    updateInformation();
                    break;
                case 7:
                    removeinformation();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break mainMenu;
                default:
                        System.out.println("그런 번호는 없습니다. 번호를 다시 입력해주세요.");
                    break;
            }

            public void addInformation() {
                System.out.println("===== 학생 정보 추가 =====");
                System.out.print("학생명 입력 : ");
                String name = sc.nextLine();
                System.out.print("학년 입력 : ");
                int grade = sc.nextInt();
                System.out.print("반 입력 : ");
                int room = sc.nextInt();
                System.out.print("번호 입력 : ");
                int number = sc.nextInt();

                StudentInformation.addList(new AttendanceDTO(name, grade, room, number));
            }



        }












    }





}
