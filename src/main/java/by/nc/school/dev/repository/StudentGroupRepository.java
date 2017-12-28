package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 24.12.2017.
 */
public interface StudentGroupRepository extends JpaRepository<Group, Long> {
}
