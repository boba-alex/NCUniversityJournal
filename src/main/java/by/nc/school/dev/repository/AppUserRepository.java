package by.nc.school.dev.repository;

import by.nc.school.dev.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}
