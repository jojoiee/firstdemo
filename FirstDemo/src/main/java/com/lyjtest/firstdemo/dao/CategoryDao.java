package com.lyjtest.firstdemo.dao;

import com.lyjtest.firstdemo.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author NoobProgrammer
 * @title: CategoryDao
 * @projectName FirstDemo
 */
public interface CategoryDao {
    List<CategoryEntity> queryPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
}
