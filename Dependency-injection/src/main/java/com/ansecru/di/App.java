package com.ansecru.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App 
{
	@Bean 
	MessageService mockMessageService(){
		return new MessageService() {
			
			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return "Hello World!";
			}
		};
	}
	
	@Bean(name="messageServiceHappy")
	MessageService messageServiceHappy(){
		return new MessageServiceHappy();
	}
	
	
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}
