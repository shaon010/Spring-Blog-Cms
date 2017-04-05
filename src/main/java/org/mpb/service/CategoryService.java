package org.mpb.service;



import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

	public List getCategoryListForDropdown() {
		return findAll().stream().map(category -> {
			return new HashMap() {{
				put("id", category.getId()) ;
				put("name", category.getTitle()) ;
			}};

		}).collect(Collectors.toList());
	}
	
}
