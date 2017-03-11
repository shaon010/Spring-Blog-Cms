package org.mpb.controller;

import org.mpb.base.ControllerBase;
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
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.security.Principal;
import java.util.List;

/**
 * Created by Shaon on 1/31/2016.
 */
@Controller
public class PostController extends ControllerBase {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ServletContext context;


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
    public String doAddPost( HttpServletRequest request,
                            @ModelAttribute("post") Post post, @RequestParam CommonsMultipartFile[] imageName,
                            Principal principal) {

        // saveDirectory =  new File(".").getCanonicalPath();  retunt location C://tomcat-8/bin

        String saveDirectory = context.getRealPath("/resources/img/postImages");

        System.out.println("total file:"+ imageName.length);

        try {
            if (imageName != null && imageName.length > 0) {
                for (CommonsMultipartFile aFile : imageName){
                    System.out.println("Saving file: " + aFile.getOriginalFilename());
                    String filename = aFile.getOriginalFilename();
                    post.setBannerImageName(filename);
                    if (!aFile.getOriginalFilename().equals("")) {
                        aFile.transferTo(new File(saveDirectory+"/"+aFile.getOriginalFilename()));
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        String name = principal.getName();
        postService.save(post, name);
        return "redirect:/index.html";
    }

    @RequestMapping(value = "post/{title}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable String title, @RequestParam Integer postId) {
        model.addAttribute("post", postService.findOneWithComments(title, postId));
        return "post";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws ServletException {

        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());

    }

    @RequestMapping(value = "/post/{title}", method = RequestMethod.POST)
    public String doAddComment(Model model, @Valid @ModelAttribute("comment") Comment comment, BindingResult result,
                               Principal principal, @PathVariable String title, @RequestParam int postId) {

        if (principal != null) {
            String name = principal.getName();
            commentService.save(comment, name, postId);
        }
        else
            commentService.save(comment, postId);
        return "redirect:/post/{title}.html?postId=" + comment.getPost().getId().toString();
    }

    @ModelAttribute("categoryList")
    public List<Category> populateCategoryList() {
        List<Category> categoryList = categoryService.findAll();
        return categoryList;
    }
}
