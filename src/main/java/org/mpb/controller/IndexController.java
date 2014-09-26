package org.mpb.controller;

import org.mpb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private PostService postService;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("posts", postService.getPosts());
		return "index";
	}
}
