package com.lyh.mapper;

import com.lyh.entity.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IFileMapper {
    @Select("<script>select <if test=\"id>-1\"> fileName,realName </if> <if test=\"id==-1\">*</if> from t_file <if test=\"id>-1\">" +
            " where id =#{id}</if></script>")
    public List<File> listFiles(@Param("id") int id);
    @Insert("insert into t_file values (null,#{file.fileName},#{file.fileDesc},#{file.realName})")
    public int insertFileInfo(@Param("file") File file);
}
