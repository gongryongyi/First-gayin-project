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
        this.name = name;
        this.id = AttendanceDTO.nextId++;


    }
}
