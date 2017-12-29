package by.nc.school.dev.repository;

import by.nc.school.dev.entity.AppUser;
import by.nc.school.dev.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public List<Subject> findAllByName(String name);
    public Subject findOneByName(String name);
}
