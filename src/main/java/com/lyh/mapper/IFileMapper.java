package com.lyh.mapper;

import com.lyh.entity.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IFileMapper {
    @Select("select * from t_file")
    public List<File> listFiles();
    @Insert("insert into t_file values (null,#{file.fileName},#{file.fileDesc},#{file.realName})")
    public int insertFileInfo(@Param("file") File file);
}
