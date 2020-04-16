package cn.ituring.design_patterns.p1_iterator;

import java.util.Objects;

/**
 * Iterator 迭代器 
 * 该角色负责定义按顺序遍历元素的接口(API)
 * 遍历元素需要的方法有： 1、hasNext()； 2、next();
 */
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}
