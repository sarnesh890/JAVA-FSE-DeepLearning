package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean (with BookRepository injected)
        BookService bookService = (BookService) context.getBean("bookService");

        // Test method
        bookService.addBook("Effective Java");

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
