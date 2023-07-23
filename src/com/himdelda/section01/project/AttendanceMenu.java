package com.himdelda.section01.project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AttendanceMenu {
    private StudentInformation infor = new StudentInformation();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {

        mainMenu:
        while (true) {
            System.out.println("========== 메뉴 ==========");
            System.out.println("1. 학생 정보 추가");
            System.out.println("2. 출석부 조회");
            System.out.println("3. 정렬하여 조회");
            System.out.println("4. 학생명으로 검색");
            System.out.println("5. 학생 정보 수정");
            System.out.println("6. 학생 정보 삭제");
            System.out.println("0. 프로그램 종료");

            System.out.print("어떤것을 도와드릴까요? : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    addinformation();
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
                    updateInformation();
                    break;
                case 6:
                    removeinformation();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break mainMenu;
                default:
                    System.out.println("그런 번호는 없습니다. 번호를 다시 입력해주세요.");
                    break;
            }

        }

    }

    public void addinformation() {
        System.out.println("===== 학생 정보 추가 =====");
        System.out.print("학생명 입력 : ");
        String name = sc.nextLine();
        System.out.print("학년 입력 : ");
        int grade = sc.nextInt();
        System.out.print("반 입력 : ");
        int room = sc.nextInt();
        System.out.print("번호 입력 : ");
        int number = sc.nextInt();

        infor.addinformation(new AttendanceDTO(name, grade, room, number));
    }

    public void selecAttendance() {
        System.out.println("====학생 정보 전체 조회====");
        List<AttendanceDTO> attendanceList = infor.selectAttendance();

        if (!attendanceList.isEmpty()) {
            for (AttendanceDTO stu : attendanceList) {
                System.out.println(stu);
            }
        } else {
            System.out.println("목록이 존재하지 않습니다.");
        }

    }

    public void sortMenu() {
        System.out.println("===== 정렬 메뉴 =====");
        System.out.println("1. 학생명 오름차순 정렬");
        System.out.println("2. 학년 오름차순 정렬");
        System.out.println("3. 학번 오름차순 정렬");
        System.out.println("4. 학생명 내림차순 정렬");
        System.out.println("5. 학년 반 오내림차순 정렬");
        System.out.println("6. 학번 내림차순 정렬");
        System.out.print("메뉴 선택 : ");
        int menu = sc.nextInt();

        Desc(menu);
    }

    public void Desc(int menu) {
        System.out.println("===== 정렬하여 조회 =====");
        List<AttendanceDTO> studentList = infor.selectAttendance();

        if (studentList.isEmpty()) {
            System.out.println("학생 정보가 존재하지 않습니다.");
            return;
        }


        List<AttendanceDTO> sortList = new ArrayList<>();
        sortList.addAll(studentList);

        if (menu == 1) {

            sortList.sort(new Comparator<AttendanceDTO>() {
                @Override
                public int compare(AttendanceDTO o1, AttendanceDTO o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        } else if (menu == 2) {
            sortList.sort(new Comparator<AttendanceDTO>() {
                @Override
                public int compare(AttendanceDTO o1, AttendanceDTO o2) {
                    return Integer.compare(o1.getGrade(), o2.getGrade());
                }
            });
        } else if (menu == 3) {
            sortList.sort(new Comparator<AttendanceDTO>() {
                @Override
                public int compare(AttendanceDTO o1, AttendanceDTO o2) {
                    return Integer.compare(o1.getNum(), o2.getNum());
                }
            });
        } else if (menu == 4) {
            sortList.sort(new Comparator<AttendanceDTO>() {
                @Override
                public int compare(AttendanceDTO o1, AttendanceDTO o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
        } else if (menu == 5) {
            sortList.sort(new Comparator<AttendanceDTO>() {
                @Override
                public int compare(AttendanceDTO o1, AttendanceDTO o2) {
                    return Integer.compare(o2.getGrade(), o1.getGrade());
                }
            });
        } else if (menu == 6) {
            sortList.sort(new Comparator<AttendanceDTO>() {
                @Override
                public int compare(AttendanceDTO o1, AttendanceDTO o2) {
                    return Integer.compare(o2.getNum(), o1.getNum());
                }
            });


        }
        for (int i = 0; i < sortList.size(); i++) {
            System.out.println(sortList.get(i));
        }
    }

    public void searchStudent() {
        System.out.println("===== 학생명으로 검색 =====");
        System.out.print("학생명 입력 : ");
        List<AttendanceDTO> searchList = infor.searchStudent(sc.nextLine());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void updateInformation() {
        System.out.println("===== 학생 정보 수정 =====");
        System.out.print("수정할 학생의 id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 학생명 : ");
        String updateName = sc.nextLine();
        System.out.print("수정할 학년 : ");
        int updateGrade = sc.nextInt();
        System.out.print("수정할 반 : ");
        int updateRoom = sc.nextInt();
        System.out.print("수정할 학번 : ");
        int updateNum = sc.nextInt();

        AttendanceDTO updateInformation = new AttendanceDTO(id, updateName, updateGrade, updateRoom, updateNum);

        if (infor.updateInformation(updateInformation)) {
            System.out.println("성공적으로 수정되었습니다.");
        } else {
            System.out.println("수정할 학생 정보를 찾지 못했습니다.");
        }
    }

    public void removeinformation() {
        System.out.println("===== 학생 정보 삭제 =====");
        System.out.print("삭제할 학생의 id : ");
        if (infor.removeInformation(sc.nextInt())) {
            System.out.println("성공적으로 삭제 되었습니다.");
        } else {
            System.out.println("삭제할 학생 정보를 찾지 못했습니다.");
        }
        sc.nextLine();
    }

}

