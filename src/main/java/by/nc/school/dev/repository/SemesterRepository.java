package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Semester;
import by.nc.school.dev.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 29.12.2017.
 */
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    public Semester findOneBySemesterNumber(int semesterNumder);
}
