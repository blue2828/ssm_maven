package com.lyh.controller;

import com.lyh.entity.User;
import com.lyh.service.IGradeService;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
public class GradeController {
    private JSONObject jb=null;

    public JSONObject getJb() {
        return jb;
    }

    public void setJb(JSONObject jb) {
        this.jb = jb;
    }

    @Resource
    private IGradeService gradeService;
    @ResponseBody
    @RequestMapping(value="/validateUser")
    public JSONObject validateUser(User user){
        jb=new JSONObject();
        User u=gradeService.validateUser(user);
        if(u==null) jb.put("msg","账号或密码错误");
        else jb.put("msg","验证成功");
        return jb;
    }
}
