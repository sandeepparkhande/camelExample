package com.bny.camel.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;

@Configuration
public class JMSConfig {

    @Bean
    public JmsTransactionManager jmsTransactionManager(final ConnectionFactory connectionFactory) {
        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
        jmsTransactionManager.setConnectionFactory(connectionFactory);
        return jmsTransactionManager;
    }

    @Bean
    public JmsComponent jms( JmsTransactionManager jmsTransactionManager) {
    	ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
    	connectionFactory.setBrokerURL("tcp://localhost:61616");
    	connectionFactory.setUserName("admin");
    	connectionFactory.setPassword("admin");
        JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(connectionFactory);
        return jmsComponent;
    }
    
    @Bean
    @Qualifier("jmsOther")
    public JmsComponent jmsOther(final JmsTransactionManager jmsTransactionManager) {
    	ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
    	connectionFactory.setBrokerURL("tcp://localhost:61616");
    	connectionFactory.setUserName("admin");
    	connectionFactory.setPassword("admin");
        JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(connectionFactory);
        return jmsComponent;
    }
    
}
