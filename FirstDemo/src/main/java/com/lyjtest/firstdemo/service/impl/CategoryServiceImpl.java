package com.lyjtest.firstdemo.service.impl;

import com.lyjtest.firstdemo.dao.CategoryDao;
import com.lyjtest.firstdemo.entity.CategoryEntity;
import com.lyjtest.firstdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NoobProgrammer
 * @title: CategoryServiceImpl
 * @projectName FirstDemo
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Override
    public List<CategoryEntity> queryList(int startIndex, int pageSize) {
        return categoryDao.queryPage(startIndex,pageSize);
    }
}
