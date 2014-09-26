package org.mpb.service;



import java.util.List;

import org.mpb.entity.Category;
import org.mpb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository ;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	
	
}
