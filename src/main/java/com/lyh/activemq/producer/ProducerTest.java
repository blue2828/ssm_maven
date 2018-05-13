package com.lyh.activemq.producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath*:applicationContext-mq.xml")*/
@Controller
public class ProducerTest {
    private QueueProducer queueProducer;

    public QueueProducer getQueueProducer() {
        return queueProducer;
    }

    public void setQueueProducer(QueueProducer queueProducer) {
        this.queueProducer = queueProducer;
    }

    @Autowired
    @Qualifier("topicProducer")
    private TopicProducer topicProducer;
    public static void main(String args[]){
        ProducerTest producerTest=new ProducerTest();
        producerTest.queueProducer.send("springQueue","这是一个队列消息");
        producerTest.topicProducer.send("springTopic","这是一个广播消息");
    }
}
