package com.lyh.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
@Service
public class TopicProducer {
    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jsmTemplate;
    public void send(String topicName,final String msg){
        jsmTemplate.send(topicName,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
