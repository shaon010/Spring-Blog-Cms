package org.mpb.repository;

import java.util.List;

import org.mpb.entity.Category;
import org.mpb.entity.Post;
import org.mpb.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer>{

	List<Post> findByUser(Users user);

	Post findById(int id);

	Post findByTitle(String title);

	Post findByTitleAndId(String title, int id);

	Page<Post> findAllByCategory(Category category, Pageable page);
}
