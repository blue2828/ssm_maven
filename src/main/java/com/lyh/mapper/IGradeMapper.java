package com.lyh.mapper;

import com.lyh.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGradeMapper {
    @Select("select * from t_user where userName=#{userName} and password=#{password} ")
    public List<User> validateUser(User user);
}
