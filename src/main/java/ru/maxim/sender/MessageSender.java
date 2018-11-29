package ru.maxim.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MessageSender {

    @Autowired
    private ConnectionFactory factory;
    @Autowired
    private Queue queue;

    public void send(String message)  {
        try {
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(queue);

            TextMessage textMessage = session.createTextMessage(message);

            producer.send(textMessage);
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
