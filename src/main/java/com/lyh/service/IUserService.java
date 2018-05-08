package com.lyh.service;

import com.lyh.entity.PageBean;
import com.lyh.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> selectByCon(PageBean pageBean);
    public int delUser(int id);
    public int insertUser(User user);
    public int updateUser(User user);
}
