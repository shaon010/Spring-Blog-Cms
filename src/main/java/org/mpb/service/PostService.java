package org.mpb.service;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.mpb.entity.Category;
import org.mpb.entity.Comment;
import org.mpb.entity.Post;
import org.mpb.entity.Users;
import org.mpb.repository.CategoryRepository;
import org.mpb.repository.CommentRepository;
import org.mpb.repository.PostRepository;
import org.mpb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	public void save(Post post, String name) {
		Users user = userRepository.findByName(name);
		
		post.setPublishedDate(new Date());
		
		/*
		 * When you don't save publishedDate as TIMESTAMP, Use this code to set Date to Time and Date (DATETIME) and sec bla bla bla ....
		 * Specially for mysql, postgre etc
		 * 
		 * 
		 * 
		 * String st =new Date().toString();
		
		try {
			Date pubdate = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(st);
			post.setPublishedDate(pubdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*
		*
		*
		*/
		
		post.setUser(user);
		postRepository.save(post);
		
	}	

	@PreAuthorize("#post.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("post") Post post) {
		postRepository.delete(post);
	}

	public Post findOne(int id) {
		return postRepository.findOne(id);
	}
	
	public Page getPosts(Integer pageNo, Integer size) {
		if (pageNo == null)
			pageNo = 0;
		return postRepository.findAll(new PageRequest(pageNo, size, Direction.DESC, "publishedDate"));
	}

	public Page getPosts(Integer pageNo, Integer size, int categoryId) {
		if (pageNo == null)
			pageNo = 0;
		Category category = categoryRepository.findById(categoryId);
		return postRepository.findAllByCategory(category, new PageRequest(pageNo, size, Direction.DESC, "publishedDate"));
	}

	@Transactional
	public Post findOneWithComments(String title, int postId) {
		Post post = postRepository.findByTitleAndId(title, postId);
		List<Comment> comments = commentRepository.findByPost(post, new PageRequest(0, 10, Direction.ASC, "publishedDate"));
	
		post.setComment(comments);
		return post;
	}

}
