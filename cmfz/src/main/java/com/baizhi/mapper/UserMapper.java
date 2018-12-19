package com.baizhi.mapper;

import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    public User selectOneByPhone(String phone);

}
