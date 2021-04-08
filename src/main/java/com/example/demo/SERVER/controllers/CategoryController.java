package com.example.demo.SERVER.controllers;

import com.example.demo.SERVER.repository.CategoryRepository;
import com.example.demo.SERVER.tables.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/addCategory")
    Category createCategory(@RequestBody Category category){
        System.out.println(category);
        return this.categoryRepository.save(category);
    }

    @GetMapping("/getCategory={id}")
    Category getClient(@PathVariable Long id){
        return this.categoryRepository.findCategoryById(id);
    }

    @GetMapping("/allClients")
    List<Category> getClientAll(){
        return this.categoryRepository.findAll();
    }



}

