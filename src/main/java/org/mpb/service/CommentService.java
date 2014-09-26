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
	public void save(Comment comment, String name, String title) {
		Users user = userRepository.findByName(name);
		Post post = postRepository.findByTitle(title);
		comment.setPublishedDate(new Date());
		comment.setUser(user);
		comment.setPost(post);
		commentRepository.save(comment);
		
	}

}
