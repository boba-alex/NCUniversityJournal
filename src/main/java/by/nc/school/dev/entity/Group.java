package by.nc.school.dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_table")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String groupNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    private List<WorkPlan> workPlans;

    public Group(){
    }

    public Group(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

}
