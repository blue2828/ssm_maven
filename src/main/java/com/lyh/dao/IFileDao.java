package com.lyh.dao;

import com.lyh.entity.File;

import java.util.List;

public interface IFileDao {
    public List<File> listFiles();
    public int insertFileInfo(File file);
}
