package cn.ituring.design_patterns.p1_iterator;

/**
 * Aggregate 集合
 * 该角色负责定义创建Iterator角色的接口(API), 这个接口(API)是一个方法，
 * 会创建出"按顺序访问保存在我内部元素的人"
 */
public interface Aggregate {
    public abstract Iterator iterator();
}
