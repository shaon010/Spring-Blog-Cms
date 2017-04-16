package org.mpb.controller;

import org.mpb.base.ControllerBase;
import org.mpb.entity.Category;
import org.mpb.service.CategoryService;
import org.mpb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class IndexController extends ControllerBase {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

	@RequestMapping(value = {"/index", "/", "/index/{pageNo}"})
	public String paginatedPost(Model model, @PathVariable Optional<Integer> optionalPageNo, @RequestParam(required = false) Integer categoryId) {
	    // @PathVariable Map<String, String> pathVariables is supported
	    int pageNo = 1;
	    if(optionalPageNo.isPresent()) {
	        pageNo = optionalPageNo.get();
        }
        int size = 6;
        Page blogPage;
        if(categoryId != null) {
            blogPage =  postService.getPosts(pageNo-1, size, categoryId);
        }
        else {
            blogPage =  postService.getPosts(pageNo-1, size);
        }
        int current = blogPage.getNumber() + 1;
        int begin = Math.max(1, current - 3);
        int end = Math.min(begin + 6, blogPage.getTotalPages());
        String categorySuffix = categoryId != null? ("?categoryId=" + categoryId) : "";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
		model.addAttribute("posts", blogPage);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categorySuffix", categorySuffix);
		model.addAttribute("categoryList", categoryService.getCategoryListForDropdown());
		return "index";
	}

    @RequestMapping(value = {"/categoryList"})
    public @ResponseBody
    List getCategoryList() {
/*
***Playing with stream and lambdas!!****
        categoryService.findAll().stream().map(category -> {
            category.setPosts(null);
            return category;
        }).collect(Collectors.toList()); // retrun a list of category . nullified posts

        categoryService.findAll().stream().map(Category::getId).collect(Collectors.toList()); // return a list , only of id

        */
       return categoryService.getCategoryListForDropdown();
       //return categoryService.findAll();
    }
}
