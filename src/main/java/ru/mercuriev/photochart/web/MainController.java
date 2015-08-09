package ru.mercuriev.photochart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mercuriev.photochart.service.CountService;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    CountService service;

    @RequestMapping("/")
    public String get(Model model) throws IOException, InterruptedException {
        model.addAttribute("list", service.list());
        return "main";
    }

}
