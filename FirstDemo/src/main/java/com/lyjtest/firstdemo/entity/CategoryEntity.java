package com.lyjtest.firstdemo.entity;

import lombok.Data;


/**
 * @author NoobProgrammer
 * @title: CategoryEntity
 * @projectName FirstDemo
 */
@Data
public class CategoryEntity {
    private Long catId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;

}
