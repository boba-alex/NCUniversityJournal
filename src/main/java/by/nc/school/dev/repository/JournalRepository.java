package by.nc.school.dev.repository;

import by.nc.school.dev.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 29.12.2017.
 */
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
