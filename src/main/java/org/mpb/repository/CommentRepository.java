package org.mpb.repository;

import java.util.List;

import org.mpb.entity.Comment;
import org.mpb.entity.Post;
import org.mpb.entity.Users;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CommentRepository extends JpaRepository<Comment, Integer>{

	List<Comment> findByPost(Post post, Pageable pageable);
	
}