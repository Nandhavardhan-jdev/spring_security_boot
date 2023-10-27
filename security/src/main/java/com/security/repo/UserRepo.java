package com.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.dao.UserDao;

@Repository
public interface UserRepo extends JpaRepository<UserDao, Long> {

	@Query(value = "SELECT * FROM user WHERE BINARY username = ?", nativeQuery = true)
	UserDao findByUsername(String username);

}
