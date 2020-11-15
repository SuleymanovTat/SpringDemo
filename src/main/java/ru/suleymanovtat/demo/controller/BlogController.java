package ru.suleymanovtat.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.suleymanovtat.demo.models.Post;
import ru.suleymanovtat.demo.repository.PostRepository;

@Controller
public class BlogController {
    @Autowired
    private PostRepository mPostRepository;

    @GetMapping("/blog")
    public String main(Model model) {
        model.addAttribute("title", "Blog");
        model.addAttribute("descriptions", "Добро пожаловать на сайт: Как одеть ребенка");

        Iterable<Post> posts = mPostRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
}
