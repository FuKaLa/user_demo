package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    String selectUser();

    List<Map> selectList(List<User> list);

    String selectOne(@Param(value = "s") String s);
}
