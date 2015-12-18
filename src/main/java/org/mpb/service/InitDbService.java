package org.mpb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.mpb.entity.Category;
import org.mpb.entity.Post;
import org.mpb.entity.Role;
import org.mpb.entity.Users;
import org.mpb.repository.CategoryRepository;
import org.mpb.repository.PostRepository;
import org.mpb.repository.RoleRepository;
import org.mpb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@PostConstruct
	public void init() {
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			
			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);

			Users userAdmin = new Users();
			userAdmin.setEnabled(1);
			userAdmin.setName("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleAdmin);
			roles.add(roleUser);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);
			
			Users user1 = new Users();
			user1.setEnabled(1);
			user1.setName("sss");
			user1.setPassword(encoder.encode("sssss"));
			
			List<Role> roles1 = new ArrayList<Role>();
			roles1.add(roleUser);
			user1.setRoles(roles1);
			userRepository.save(user1);

			 Category category1 =new Category();
			 category1.setTitle("java core");
			 categoryRepository.save(category1);
			 
			 Category category2 =new Category();
			 category2.setTitle("spring");
			 categoryRepository.save(category2);
			 
			 Category category3 =new Category();
			 category3.setTitle("grails");
			 categoryRepository.save(category3);
			 
			 Category category4 =new Category();
			 category4.setTitle("others");
			 categoryRepository.save(category4);
			 
			 Post post = new Post();
			 post.setTitle("Sony ericsson Xperia Ray looks great");
			 post.setDescription("It's been a busy old year for Sony Ericsson." +
					 " As it struggles to regain a foothold in the market it " +
					 "was once sucha major player in, it's been firing out more " +
					 "Android-based Xperia smartphones than long-lost relatives on " +
					 "an episode of Jeremy Kyle. And they're not half bad either. " +
					 "The Xperia Arc has been the flagship of 2011's bunch. Arriving " +
					 "in the spring, it became the skinny poster girl for the Swedish-Japanese" +
					 " hybrid, showing off its amazing screen presence with the help of the" +
					 " Sony Reality Display (the bit that reproduces colour on the screen and" +
					 " makes it look great) but in the Xperia Ray, Sony Ericsson has gone " +
					 "for a smaller model.");
			 post.setPublishedDate(new Date());
			 post.setUser(userAdmin);
			 post.setCategory(category4);
			 postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

			post = new Post();
			post.setTitle("Sony ericsson Xperia Ray looks great");
			post.setDescription("It's been a busy old year for Sony Ericsson");
			post.setPublishedDate(new Date());
			post.setUser(userAdmin);
			post.setCategory(category4);
			postRepository.save(post);

		}
	}
}

