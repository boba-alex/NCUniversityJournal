package by.nc.school.dev.entity;

import javax.persistence.*;

@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String groupNumber;

    public StudentGroup(){
        this.groupNumber = "1";
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentGroupNumber() {
        return groupNumber;
    }

    public void setStudentGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    //    private Curator curator;
//    private Semester currentSemester;

//    public int getGroupNumber() {
//        return groupNumber;
//    }
//
//    public void setGroupNumber(int groupNumber) {
//        this.groupNumber = groupNumber;
//    }
//
//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }
//
//    public Curator getCurator() {
//        return curator;
//    }
//
//    public void setCurator(Curator curator) {
//        this.curator = curator;
//    }
//
//    public Semester getCurrentSemester() {
//        return currentSemester;
//    }
//
//    public void setCurrentSemester(Semester currentSemester) {
//        this.currentSemester = currentSemester;
//    }
}
