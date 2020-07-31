package com.home.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.home.spring.model.Message;

public class BeanFactoryContainer {

	public static void main(String[] args) {

		Resource resource = new ClassPathResource("Beans.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		Object object = beanFactory.getBean("message");
		if (object != null) {
			Message message = (Message) object;
			System.out.println(message.getMessageId() + "\t" + message.getMessage());
		}

		System.out.println("----------------------------------");
		Message message = beanFactory.getBean("message", Message.class);
		System.out.println(message.getMessageId() + "\t" + message.getMessage());
		
		System.out.println("----------------------------------");
		String[] aliases = beanFactory.getAliases("message");
		for(String alias:aliases) {
			System.out.println(alias);
		}
		
		System.out.println("----------------------------------");
		Message message2 = beanFactory.getBean(Message.class);
		System.out.println(message2.getMessageId() + "\t" + message2.getMessage());

		System.out.println("----------------------------------");
		Class<?> cls = beanFactory.getType("message");
		System.out.println(cls.getName());
		
		System.out.println("----------------------------------");
		System.out.println(beanFactory.isSingleton("message"));
	}

}
