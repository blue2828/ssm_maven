package com.lyh.dao.imp;

import com.lyh.dao.BaseDao;
import com.lyh.dao.IUserDao;
import com.lyh.entity.PageBean;
import com.lyh.entity.User;
import com.lyh.mapper.IGradeMapper;
import com.lyh.mapper.IUserMapper;
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

    @Override
    public List<User> selectByCon(PageBean pageBean) {
        SqlSession session=getSqlSession();
        IUserMapper mapper=session.getMapper(IUserMapper.class);
        List<User> list=mapper.selectByCon(pageBean);
        return list;
    }
    public int delUser( int id){
        SqlSession session=getSqlSession();
        IUserMapper mapper=session.getMapper(IUserMapper.class);
        int num=mapper.delUser(id);
        return num;
    }

    @Override
    public int insertUser(User user) {
        SqlSession sqlSession=getSqlSession();
        IUserMapper mapper=sqlSession.getMapper(IUserMapper.class);
        int num=mapper.insertUser(user);
        return num;
    }

    @Override
    public int updateUser(User user) {
        SqlSession sqlSession=getSqlSession();
        IUserMapper mapper=sqlSession.getMapper(IUserMapper.class);
        int num=mapper.updateUser(user);
        return num;
    }


}
