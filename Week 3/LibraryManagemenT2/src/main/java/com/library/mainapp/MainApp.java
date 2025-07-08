package com.library.mainapp;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Use the service
        bookService.addBook("Domain-Driven Design");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
