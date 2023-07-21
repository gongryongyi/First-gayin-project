package com.himdelda.section01.project;

import java.util.ArrayList;
import java.util.List;

public class StudentInformation {

    private List<AttendanceDTO> attenanceList = new ArrayList<>();

    /* 곡 추가 */
    public void addList(AttendanceDTO music) {
        attenanceList.add(music);

    }
}
