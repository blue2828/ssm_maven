package com.lyh.service.imp;

import com.lyh.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Service("mailService")
public class MailSerivice implements IMailService {
    @Autowired
    @Qualifier("javaMailSender")
    private JavaMailSender javaMailSender;
    public void send(String to, String subject, String content) {
        try{
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
            helper.setFrom("2678800402@qq.com");
            if(null!=subject) helper.setSubject(subject);
            else helper.setSubject("");
            helper.setTo(to);
            helper.setText(content,true);
            javaMailSender.send(mimeMessage);
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
