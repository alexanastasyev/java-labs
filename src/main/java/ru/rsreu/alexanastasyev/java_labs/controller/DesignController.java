package ru.rsreu.alexanastasyev.java_labs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.alexanastasyev.java_labs.domain.Course;
import ru.rsreu.alexanastasyev.java_labs.domain.Language;
import ru.rsreu.alexanastasyev.java_labs.domain.Program;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {

    @ModelAttribute
    public void addCoursesToModel(Model model) {
        List<Course> courses = Arrays.asList(
            new Course("ENBA", "English basics", Language.ENGLISH),
            new Course("ENGR", "English grammar", Language.ENGLISH),
            new Course("ENVO", "English vocabulary", Language.ENGLISH),
            new Course("GEBA", "German basics", Language.GERMAN),
            new Course("GEGR", "German grammar", Language.GERMAN),
            new Course("GEVO", "German vocabulary", Language.GERMAN),
            new Course("FRBA", "French basics", Language.FRENCH),
            new Course("FRGR", "French grammar", Language.FRENCH),
            new Course("FRVO", "French vocabulary", Language.FRENCH)
        );

        Language[] languages = Language.values();
        for (Language language : languages) {
            model.addAttribute(
                    language.toString().toLowerCase(),
                    courses.stream().filter(course -> course.getLanguage().equals(language)).collect(Collectors.toList()));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("program", new Program());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("program") Program program, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }
        return "redirect:/";
    }

}
