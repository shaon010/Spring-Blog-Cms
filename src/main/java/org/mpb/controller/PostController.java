package org.mpb.controller;

import org.mpb.entity.Category;
import org.mpb.entity.Comment;
import org.mpb.entity.Post;
import org.mpb.service.CategoryService;
import org.mpb.service.CommentService;
import org.mpb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by Shaon on 1/31/2016.
 */
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("post")
    public Post constructPost() {
        return new Post();
    }

    @ModelAttribute("comment")
    public Comment constructComment() {
        return new Comment();
    }

    @RequestMapping("/post/remove/{id}")
    public String removePost(@PathVariable int id) {
        Post post = postService.findOne(id);
        postService.delete(post);
        return "redirect:/account.html";
    }

    @RequestMapping("/postwrite")
    public String showPostWrite() {
        return "postwrite";
    }

    @RequestMapping(value = "/postwrite", method = RequestMethod.POST)
    public String doAddPost(Model model,
                            @Valid @ModelAttribute("post") Post post, BindingResult result,
                            Principal principal) {
        String name = principal.getName();
        postService.save(post, name);
        return "redirect:/index.html";
    }

    @RequestMapping(value = "post/{title}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable String title, @RequestParam Integer postId) {
        model.addAttribute("post", postService.findOneWithComments(title, postId));
        return "post";
    }

    @RequestMapping(value = "/post/{title}", method = RequestMethod.POST)
    public String doAddComment(Model model, @Valid @ModelAttribute("comment") Comment comment, BindingResult result,
                               Principal principal, @PathVariable String title) {

        if (principal != null) {
            String name = principal.getName();
            commentService.save(comment, name);
        }
        else
            commentService.save(comment);
        return "redirect:/post/{title}.html?postId=" + comment.getPost().getId().toString();
    }

    @ModelAttribute("categoryList")
    public List<Category> populateCategoryList() {
        List<Category> categoryList = categoryService.findAll();
        return categoryList;
    }
}
