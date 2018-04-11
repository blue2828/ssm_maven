package com.lyh.controller;

import com.lyh.entity.File;
import com.lyh.service.IFileService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller("fileController")
@Scope("prototype")
public class FileController {
    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private JSONObject jb=null;
    public JSONObject getJb() {
        return jb;
    }
    public void setJb(JSONObject jb) {
        this.jb = jb;
    }
    @Resource
    private IFileService fileService;
    @ResponseBody
    @RequestMapping("/getFileInfo")
    public JSONObject listFiles(){
        jb=new JSONObject();
        List<File> list=fileService.listFiles();
        JSONArray array=list==null?null:JSONArray.fromObject(list);
        jb.put("data",array);
        jb.put("code",0);
        jb.put("count",list==null?0:list.size());
        jb.put("msg","");
        return jb;
    }
    @RequestMapping("/uploadFile")
    @ResponseBody
    public JSONObject uploadFile(@RequestParam(value="hh",required = false) MultipartFile uploadFile)throws Exception{
        jb=new JSONObject();
        String directory="D:/fileplUoad";
        if(uploadFile.getSize()<=0){
            System.out.println("上传错误，请检查当前是否有文件被选中上传");
            jb.put("code",0);
        }else{
            String originalFileName=uploadFile.getOriginalFilename();
            String fullName=directory+mkFullFileName(originalFileName);
            File file=new File(fullName,"待定",originalFileName);
            int num=fileService.insertFileInfo(file);
            if(num>0){
                java.io.File storeFile=new java.io.File(fullName);
                try{
                    uploadFile.transferTo(storeFile);
                    jb.put("code",1);
                }catch (IOException e){
                    e.printStackTrace();
                    jb.put("code",2);
                }catch (Exception e){
                    e.printStackTrace();
                    jb.put("code",2);
                }
            }
            else jb.put("code",0);
        }
        return jb;
    }
    public String mkFullFileName(String originalFileName){
        return UUID.randomUUID().toString().replaceAll("-","_")+"_"+originalFileName.replaceAll("-","_");
    }
}
