package com.lyjtest.firstdemo.controller;

import com.lyjtest.firstdemo.entity.CategoryEntity;
import com.lyjtest.firstdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author NoobProgrammer
 * @title: CategoryController
 * @projectName FirstDemo
 */
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryEntity> list(@RequestParam("page") int startIndex, @RequestParam("pagesize") int pageSize) {
        List<CategoryEntity> categoryEntities = categoryService.queryList(startIndex,pageSize);
        return  categoryEntities;
    }
}
