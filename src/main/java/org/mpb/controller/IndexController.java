package org.mpb.controller;

import org.mpb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@Autowired
	private PostService postService;

	@RequestMapping(value = {"/index", "/"})
	public String index(Model model) {
        int pageNo = 1;
        int size = 10;
        Page blogPage =  postService.getPosts(pageNo-1, size);
        int current = blogPage.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, blogPage.getTotalPages());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
		model.addAttribute("posts", blogPage);
		return "index";
	}

	@RequestMapping(value = {"/index/{pageNo}"})
	public String paginatedPost(Model model, @PathVariable int pageNo) {
        int size = 10;
        Page blogPage =  postService.getPosts(pageNo-1, size);
        int current = blogPage.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, blogPage.getTotalPages());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
		model.addAttribute("posts", blogPage);
		return "index";
	}
}
