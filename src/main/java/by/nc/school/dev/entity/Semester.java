package by.nc.school.dev.entity;

import javax.persistence.*;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private int semesterNumber;

    public Semester() {
        this.semesterNumber = 1;
    }

    public Semester(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public Long getId() {
        return id;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }
}
