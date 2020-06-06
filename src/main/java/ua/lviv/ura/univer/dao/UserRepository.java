package ua.lviv.ura.univer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.ura.univer.domain.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
}
