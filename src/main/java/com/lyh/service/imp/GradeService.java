package com.lyh.service.imp;

import com.lyh.dao.IUserDao;
import com.lyh.entity.User;
import com.lyh.service.IGradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("gradeService")
public class GradeService implements IGradeService {
    @Resource
    private IUserDao userDao;

    public User validateUser(User user) {
        return userDao.validateUser(user);
    }
}
