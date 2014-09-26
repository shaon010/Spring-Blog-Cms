package org.mpb.repository;

import org.mpb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByName(String name);


}
