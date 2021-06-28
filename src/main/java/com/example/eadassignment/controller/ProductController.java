package com.example.eadassignment.controller;

import com.example.eadassignment.dto.ProductDTO;
import com.example.eadassignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("list", productService.getList().stream().map(x -> new ProductDTO(x))
                .collect(Collectors.toList()));
        return "products/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "products/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "products/form";
        } else {
            studentService.createStudent(studentDTO);
            return "redirect:/products";
        }
    }
}
