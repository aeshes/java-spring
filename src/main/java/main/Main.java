package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import context.AppContext;
import course.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        Course course = ctx.getBean(Course.class);
        System.out.println(course.getName());
    }
}
