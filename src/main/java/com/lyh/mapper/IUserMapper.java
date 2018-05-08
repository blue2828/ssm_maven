package com.lyh.mapper;

import com.lyh.entity.PageBean;
import com.lyh.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserMapper {
    @Select("select * from t_user limit #{pageBean.start},#{pageBean.limit}")
    public List<User> selectByCon(@Param("pageBean") PageBean pageBean);
    @Delete("delete from t_user where id=#{id}")
    public int delUser(@Param("id") int id);
    @Insert("insert into t_user values(null,#{user.userName},#{user.password},#{user.email})")
    public int insertUser(@Param("user") User user);
    @Update("update t_user set userName=#{user.userName},password=#{user.password},email=#{user.email} where id=#{user.id}")
    public int updateUser(@Param("user") User user);
}
