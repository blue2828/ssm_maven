package com.lyh.service.imp;

import com.lyh.dao.IFileDao;
import com.lyh.entity.File;
import com.lyh.service.IFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("fileService")
public class FileService implements IFileService {
    @Resource
    private IFileDao fileDao;
    @Override
    public List<File> listFiles() {
        List<File> list=null;
        try{
            list=fileDao.listFiles();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertFileInfo(File file) {
        int num=0;
        try{
            num=fileDao.insertFileInfo(file);
        }catch (Exception e){
            e.printStackTrace();
            num=0;
        }
        return num;
    }
}
