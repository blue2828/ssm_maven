package com.lyh.dao.imp;

import com.lyh.dao.BaseDao;
import com.lyh.dao.IFileDao;
import com.lyh.entity.File;
import com.lyh.mapper.IFileMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fileDao")
public class FileDao extends BaseDao implements IFileDao {
    @Override
    public List<File> listFiles() {
        SqlSession session=getSqlSession();
        IFileMapper fileMapper=session.getMapper(IFileMapper.class);
        List<File> list=fileMapper.listFiles();
        return list;
    }

    @Override
    public int insertFileInfo(File file) {
        SqlSession session=getSqlSession();
        IFileMapper mapper=session.getMapper(IFileMapper.class);
        int num=mapper.insertFileInfo(file);
        return num;
    }
}
