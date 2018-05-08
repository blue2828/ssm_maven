package com.lyh.dao;

import com.lyh.entity.PageBean;
import com.lyh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    public User validateUser(User user);
    public List<User> selectByCon(PageBean pageBean);
    public int delUser( int id);
    public int insertUser(User user);
    public int updateUser(User user);
}
