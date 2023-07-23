package com.himdelda.section01.project;

public class AttendanceDTO {
    private static int nextId = 1;

    private int id;
    private String name;
    private int grade;
    private int room;
    private int num;

    public AttendanceDTO(String name, int grade, int room, int num){
        this.name = name;
        this.grade = grade;
        this.room = room;
        this.num = num;
        this.id = AttendanceDTO.nextId++;

    }
    public AttendanceDTO(int id, String name, int grade, int room, int num) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.room = room;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", room=" + room +
                ", num=" + num +
                '}';
    }
}
