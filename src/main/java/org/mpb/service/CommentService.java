package org.mpb.service;


import java.util.Date;

import javax.transaction.Transactional;

import org.mpb.entity.Comment;
import org.mpb.entity.Post;
import org.mpb.entity.Users;
import org.mpb.repository.CommentRepository;
import org.mpb.repository.PostRepository;
import org.mpb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Transactional 
	public void save(Comment comment, String name, int postId) {
		Users user = userRepository.findByName(name);
		Post post = postRepository.findById(postId);
		comment.setPublishedDate(new Date());
		comment.setPost(post);
		comment.setUser(user);
		comment.setEmail(user.getEmail());
		comment.setName(user.getName());
		commentRepository.save(comment);
		
	}

	@Transactional
	public void save(Comment comment, int postId) {
		Post post = postRepository.findById(postId);
		comment.setPost(post);
		comment.setPublishedDate(new Date());
		commentRepository.save(comment);
	}

}
