package com.lyh.service;

import com.lyh.entity.File;

import java.util.List;

public interface IFileService {
    public List<File> listFiles();
    public int insertFileInfo(File file);
}
