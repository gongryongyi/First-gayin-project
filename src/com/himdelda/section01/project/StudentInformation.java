package com.himdelda.section01.project;

import java.util.ArrayList;
import java.util.List;

public class StudentInformation {

    private List<AttendanceDTO> attenanceList = new ArrayList<>();

    /* 학생정보 추가 */
    public void addinformation(AttendanceDTO student) {
        attenanceList.add(student);

    }

    /* 학생 전체 조회 */
    public List<AttendanceDTO> selectAttendance() {

        return attenanceList;
    }

    /* 학생명 조회 */
    public List<AttendanceDTO> searchStudent(String student) {
        /* 가수명을 검색해서 해당 키워드가 포함되는 곡을 리턴하기 위한 리스트 */
        List<AttendanceDTO> searchList = new ArrayList<>();

        for (AttendanceDTO information : attenanceList){

            if (information.getName().contains(student)){
                searchList.add(information);


            }

        }
        return searchList;
    }
     /* 학생 정보 수정 */
    public boolean updateInformation(AttendanceDTO updateInformation){

        AttendanceDTO old = null;
        for (int i = 0; i < attenanceList.size(); i++){
            if (attenanceList.get(i).getId() == updateInformation.getId()){
                old = attenanceList.set(i,updateInformation);

            }

        }

        return old != null;
    }

    /* 곡 삭제  */
    public boolean removeInformation(int id) {
        AttendanceDTO old = null;
        for (int i = 0; i < attenanceList.size(); i++){
            if (attenanceList.get(i).getId() == id){
                old = attenanceList.remove(i);

            }
        }

        return old != null;
    }

}
