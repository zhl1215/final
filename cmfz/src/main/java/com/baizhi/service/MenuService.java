package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService {
    //查询所有的一级菜单和二级菜单
    public List<Menu> getAllMenus();
}
