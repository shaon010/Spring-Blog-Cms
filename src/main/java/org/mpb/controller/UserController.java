package org.mpb.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.mpb.base.ControllerBase;
import org.mpb.entity.Category;
import org.mpb.entity.Comment;
import org.mpb.entity.Post;
import org.mpb.service.CategoryService;
import org.mpb.service.CommentService;
import org.mpb.service.PostService;
import org.mpb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController extends ControllerBase {

	@Autowired
	private UserService userService;

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithPosts(name));
		return "account";
	}


}
