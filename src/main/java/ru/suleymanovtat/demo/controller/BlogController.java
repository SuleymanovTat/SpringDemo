package ru.suleymanovtat.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.suleymanovtat.demo.models.Post;
import ru.suleymanovtat.demo.repository.PostRepository;

@Controller
public class BlogController {
    @Autowired
    private PostRepository mPostRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        model.addAttribute("title", "Blog");
        model.addAttribute("descriptions", "Добро пожаловать на сайт: Как одеть ребенка");

        Iterable<Post> posts = mPostRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogadd(Model model) {
        model.addAttribute("title", "Добавить запись");
        model.addAttribute("descriptions", "Форма добавления записей");
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPost(@RequestParam String title, @RequestParam String descriptions, Model model) {
        model.addAttribute("title", "Добавить запись");
        model.addAttribute("descriptions", "Форма добавления записей");
        Post post = new Post(title, descriptions);
        mPostRepository.save(post);
        return "redirect:/blog";
    }
}
