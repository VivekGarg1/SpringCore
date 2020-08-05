package com.home.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.spring.model.Message;

public class SpringScopes {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("BeansScopes.xml");
		 Message message = context.getBean("message", Message.class);
		 message.setMessageId(1001);
		 message.setMessage("Hello Vivek!!!");
		 System.out.println(message.getMessageId()+"\t"+message.getMessage());
		 
		 Message message1 = context.getBean("message", Message.class);
		 System.out.println(message1.getMessageId()+"\t"+message1.getMessage());
		 ((AbstractApplicationContext) context).close();
	}

}
