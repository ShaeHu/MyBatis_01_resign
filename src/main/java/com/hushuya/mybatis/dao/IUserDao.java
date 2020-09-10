package com.hushuya.mybatis.dao;

import com.hushuya.mybatis.domain.User;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
//    @Select("select * from User")
    List<User> findAll();
}
