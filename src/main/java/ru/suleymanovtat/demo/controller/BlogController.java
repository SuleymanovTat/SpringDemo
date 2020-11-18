package ru.suleymanovtat.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.suleymanovtat.demo.models.Post;
import ru.suleymanovtat.demo.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!mPostRepository.existsById(id)) {
            return "redirect:/blog";
        }
        model.addAttribute("title", "Детальная информация");
        model.addAttribute("descriptions", "Информация");
        Optional<Post> post = mPostRepository.findById(id);
        List<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "blog-details";
    }

    @GetMapping("/blog/edit/{id}")
    public String blogUpdatePost(@PathVariable(value = "id") long id, Model model) {
        if (!mPostRepository.existsById(id)) {
            return "redirect:/blog";
        }
        model.addAttribute("title", "Редактирования");
        model.addAttribute("descriptions", "Редактирования информации");
        Optional<Post> post = mPostRepository.findById(id);
        List<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "blog-edit-details";
    }

    @PostMapping("/blog/edit/{id}")
    public String blogEditPost(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String descriptions, Model model) {
        model.addAttribute("title", "Добавить запись");
        model.addAttribute("descriptions", "Форма добавления записей");
        Post post = mPostRepository.findById(id).orElseThrow(RuntimeException::new);
        post.setTitle(title);
        post.setDescriptions(descriptions);
        mPostRepository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/delete/{id}")
    public String blogDeletePost(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("title", "Добавить запись");
        model.addAttribute("descriptions", "Форма добавления записей");
        Post post = mPostRepository.findById(id).orElseThrow(RuntimeException::new);
        mPostRepository.delete(post);
        return "redirect:/blog";
    }
}
