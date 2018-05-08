package com.lyh.service.imp;

import com.lyh.dao.IUserDao;
import com.lyh.entity.PageBean;
import com.lyh.entity.User;
import com.lyh.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserService implements IUserService{
    @Resource
    private IUserDao userDao;
    @Override
    public List<User> selectByCon(PageBean pageBean) {
        return userDao.selectByCon(pageBean);
    }

    @Override
    public int delUser(int id) {
        int flag=0;
        try{
            flag=userDao.delUser(id);
        }catch (Exception e){
            flag=0;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int insertUser(User user) {
        int flag=0;
        try{
            flag=userDao.insertUser(user);
        }catch (Exception e){
            flag=0;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int updateUser(User user) {
        int flag=0;
        try{
            flag=userDao.updateUser(user);
        }catch (Exception e){
            flag=0;
            e.printStackTrace();
        }
        return flag;
    }
}
