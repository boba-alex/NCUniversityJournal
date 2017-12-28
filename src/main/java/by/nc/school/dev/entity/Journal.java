package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int mark;
    private boolean isExam;
    @OneToOne
    private Semester semester;
    @OneToOne
    private Subject subject;
    @OneToOne
    private AppUser appUser;

    public Journal(int mark, boolean isExam, Semester semester, Subject subject, AppUser appUser) {
        this.mark = mark;
        this.isExam = isExam;
        this.semester = semester;
        this.subject = subject;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isExam() {
        return isExam;
    }

    public void setExam(boolean exam) {
        isExam = exam;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
