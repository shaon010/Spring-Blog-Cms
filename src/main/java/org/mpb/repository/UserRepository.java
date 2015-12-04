package org.mpb.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mpb.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByName(String name);


}
