package ua.lviv.ura.univer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.lviv.ura.univer.domain.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	@Query("select a.role from user_role a, user b where b.firstName=? and a.userId=b.userId")
	public List<String> findRolesByUserName (String username);
}
