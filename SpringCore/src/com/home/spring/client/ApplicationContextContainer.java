package com.home.spring.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.home.spring.model.Message;

public class ApplicationContextContainer {

	public static void main(String[] args) {

		ApplicationContext context = null;
		try {
			// context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
			// context = new FileSystemXmlApplicationContext("G:\\Java Development\\git\\SpringCore\\SpringCore\\src\\ApplicationContext.xml");
			//context = new FileSystemXmlApplicationContext("G:/Java Development/git/SpringCore/SpringCore/src/ApplicationContext.xml");
			context = new FileSystemXmlApplicationContext("src/ApplicationContext.xml");
			Message message = context.getBean("message", Message.class);
			System.out.println(message.getMessageId() + "\t" + message.getMessage());

			System.out.println("----------------------------------");
			Object object = context.getBean("message");
			if (object != null) {
				Message message1 = (Message) object;
				System.out.println(message1.getMessageId() + "\t" + message1.getMessage());
			}
		} catch (BeansException e) {
			e.printStackTrace();
		} finally {
			if (context != null)
				((AbstractApplicationContext) context).close();
		}
	}

}
