package ua.lviv.ura.univer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.lviv.ura.univer.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select a.email from User a, user b where b.firstName=? and a.userId=b.userId")
	Optional<User> findByEmail(String email);
}
