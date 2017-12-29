package by.nc.school.dev.entity;

import javax.persistence.*;

@Entity
public class WorkPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Subject subject;
    @OneToOne
    private Semester semester;
    @OneToOne
    private AppUser appUser;

    public WorkPlan(){}

    public WorkPlan(Subject subject, Semester semester, AppUser appUser) {
        this.subject = subject;
        this.semester = semester;
        this.appUser = appUser;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
