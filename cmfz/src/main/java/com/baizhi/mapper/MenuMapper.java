package com.baizhi.mapper;

import com.baizhi.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface MenuMapper extends Mapper<Menu> {
    //自连接查询所有一级目录以及二级目录
    public List<Menu> queryAllMenus();
}
