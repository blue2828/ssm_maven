package com.lyh.controller;

import com.lyh.activemq.producer.TopicProducer;
import com.lyh.entity.PageBean;
import com.lyh.entity.User;
import com.lyh.service.IMailService;
import com.lyh.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller("userController")
@Scope("prototype")
public class UserController {
    @Resource
    private TopicProducer topicProducer;
    @Resource
    private IUserService userService;
    @Autowired
    @Qualifier("mailService")
    private IMailService mailService;
    @RequestMapping("/getAllUser")
    @ResponseBody
    public JSONObject getAllUser(int page,int limit){
        JSONObject jb=new JSONObject();
        PageBean pageBean=new PageBean(page,limit);
        List<User> list=userService.selectByCon(pageBean);
        JSONArray array=JSONArray.fromObject(list);
        jb.put("msg","");
        jb.put("code",0);
        jb.put("data",array);
        jb.put("count",list.size());
        return jb;
    }
    @RequestMapping("/delUser")
    @ResponseBody
    public JSONObject delUser(int del_id){
        JSONObject jb=new JSONObject();
        int num=userService.delUser(del_id);
        if(num>0){
            jb.put("success",true);
        }else {
            jb.put("success",false);
            jb.put("errMsg","删除失败");
        }
        return jb;
    }
    @RequestMapping("/saveUser")
    @ResponseBody
    public JSONObject saveUser(User user,int version){
        JSONObject jb=new JSONObject();
        int flag=0;
        if(version==0){
            flag=userService.insertUser(user);
        }else{
            flag=userService.updateUser(user);
        }
        if(flag>0) jb.put("success",true);
        else jb.put("success",false);
        return jb;
    }
    @RequestMapping("/registerUser")
    @ResponseBody
    public JSONObject registerUser(User user){
        JSONObject jb=new JSONObject();
        int num=userService.insertUser(user);
        if(num>0) {
            jb.put("success",true);
            topicProducer.send("springTopic","恭喜您成功注册");
            mailService.send(user.getEmail(),"注册结果","恭喜您成功注册系统");
        }
        else {
            jb.put("success",false);
            jb.put("errMsg","注册失败！");
        }
        return jb;
    }
}
