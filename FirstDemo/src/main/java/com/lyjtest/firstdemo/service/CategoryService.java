package com.lyjtest.firstdemo.service;

import com.lyjtest.firstdemo.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NoobProgrammer
 * @title: CategoryService
 * @projectName FirstDemo
 */
public interface CategoryService {

    List<CategoryEntity> queryList(int startIndex, int pageSize);
}
