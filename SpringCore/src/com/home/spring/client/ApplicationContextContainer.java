package com.home.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.spring.model.Message;

public class ApplicationContextContainer {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Message message = context.getBean("message", Message.class);
		System.out.println(message.getMessageId() + "\t" + message.getMessage());
		
		System.out.println("----------------------------------");
		Object object = context.getBean("message");
		if (object != null) {
			Message message1 = (Message) object;
			System.out.println(message1.getMessageId() + "\t" + message1.getMessage());
		}
		
		System.out.println("----------------------------------");
		
		
		((AbstractApplicationContext) context).close();

	}

}
