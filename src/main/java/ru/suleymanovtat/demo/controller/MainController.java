package ru.suleymanovtat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Welcome my site");
        model.addAttribute("text", "Как одеть ребенка");
        model.addAttribute("descriptions", "Добро пожаловать на сайт: Как одеть ребенка");
        return "main";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        model.addAttribute("text", "Как одеть ребенка");
        model.addAttribute("descriptions", "Добро пожаловать на сайт: Как одеть ребенка");
        return "about";
    }

}