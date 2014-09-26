package org.mpb.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.mpb.entity.Post;
import org.mpb.entity.Role;
import org.mpb.entity.Users;
import org.mpb.repository.PostRepository;
import org.mpb.repository.RoleRepository;
import org.mpb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	
	
	@Autowired
	private PostRepository postRepository;
	

	public List<Users> findAll() {
		return userRepository.findAll();
	}

	public Users findOne(int id) {
		return userRepository.findOne(id);
	}
	
	@Transactional
	public Users findOneWithPosts(int id) {
		Users user = findOne(id);
		List<Post> posts = postRepository.findByUser(user);
		user.setPosts(posts);
		return user;
	}

	public void save(Users user) {
		user.setEnabled(1);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);

		userRepository.save(user);
	}

	public Users findOneWithPosts(String name) {
		Users user = userRepository.findByName(name);
		return findOneWithPosts(user.getId());
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(@P("id")int id) {
		userRepository.delete(id);
	}

	public Users findOne(String username) {
		return userRepository.findByName(username);
	}

}
