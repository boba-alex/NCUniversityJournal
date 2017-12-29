package by.nc.school.dev.entity;

import javax.persistence.*;

public class WorkPlanModel {

    private String subjectName;

    private String semesterNumber;

    private String appUserUserName;

    public WorkPlanModel(){}
    public WorkPlanModel(String semesterNumber, String subjectName, String appUserUserName) {
        this.subjectName = subjectName;
        this.semesterNumber = semesterNumber;
        this.appUserUserName = appUserUserName;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(String semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public String getAppUserUserName() {
        return appUserUserName;
    }

    public void setAppUserUserName(String appUserUserName) {
        this.appUserUserName = appUserUserName;
    }
}
