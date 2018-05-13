package com.lyh.activemq.consumer;

import org.springframework.stereotype.Service;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
@Service
public class QueueConsumer1 implements MessageListener{
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage)message;
        try{
            System.out.println("queueConsumer1获取到的消息："+textMessage.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
