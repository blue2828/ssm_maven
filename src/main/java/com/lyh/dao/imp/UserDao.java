package com.lyh.dao.imp;

import com.lyh.dao.BaseDao;
import com.lyh.dao.IUserDao;
import com.lyh.entity.User;
import com.lyh.mapper.IGradeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDao extends BaseDao implements IUserDao {

    @Override
    public User validateUser(User user) {
        SqlSession session=getSqlSession();
        IGradeMapper mapper=session.getMapper(IGradeMapper.class);
        List<User> list=mapper.validateUser(user);
        return list.get(0);
    }
}
