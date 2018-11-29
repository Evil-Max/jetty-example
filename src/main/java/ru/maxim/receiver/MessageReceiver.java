package ru.maxim.receiver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MessageReceiver {

    @Autowired
    private ConnectionFactory factory;
    @Autowired
    private Queue queue;

    public String receive() {
        String message="";
        try {
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageConsumer consumer = session.createConsumer(queue);
            Message received_message = consumer.receive();
            if (received_message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) received_message;
                message = textMessage.getText();
            }
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return message;
    }
}
