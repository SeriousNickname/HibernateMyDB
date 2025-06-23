package org.example.controller;

import org.example.entity.Stuff;
import org.example.services.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Контроллер работающий с методами сервиса и возвращающий представление из соответствующих .jsp файлов.
 * Использование слова stuff неопределённого числа, вместо employee очень плохо сказалось на понимании объектов с которыми я работаю на этом этапе.
 * */

@Controller
@RequestMapping("/stuff")
public class StuffController {

    private final StuffService stuffService;

    @Autowired
    public StuffController(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @GetMapping()
    public String getAllStuff(Model model) {
        List<Stuff> stuffList = stuffService.getAllStuff();
        model.addAttribute("stuffList", stuffList);
        return "stuff/list"; // Имя JSP-файла для отображения списка пользователей
    }

    @GetMapping("/new")
    public String newStuff(Model model) {
        model.addAttribute("stuff", new Stuff());
        return "stuff/new"; // Имя JSP-файла для формы создания нового пользователя
    }

    @PostMapping()
    public String createStuff(@ModelAttribute("stuff") Stuff stuff) {
        stuffService.saveStuff(stuff);
        return "redirect:/stuff"; // Перенаправление на страницу со списком сотрудников
    }

    @GetMapping("/{id}/edit")
    public String editStuff(@PathVariable("id") Long id, Model model) {
        model.addAttribute("stuff", stuffService.findById(id));
        return "stuff/edit"; // Имя JSP-файла для формы редактирования пользователя
    }

    @PatchMapping("/{id}")
    public String updateStuff(@ModelAttribute("stuff") Stuff stuff, @PathVariable("id") Long id) {
        stuffService.updateStuff(id, stuff);
        return "redirect:/stuff"; // Перенаправление на страницу со списком сотрудников
    }

    @DeleteMapping("/{id}")
    public String deleteStuff(@PathVariable("id") Long id) {
        stuffService.deleteById(id);
        return "redirect:/stuff"; // Перенаправление на страницу со списком сотрудников
    }

}
