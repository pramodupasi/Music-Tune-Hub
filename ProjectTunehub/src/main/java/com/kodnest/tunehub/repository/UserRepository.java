package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import com.kodnest.tunehub.entity.User;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, String>{

	public User findByEmail(String email);

}
