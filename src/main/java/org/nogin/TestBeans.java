package org.nogin;

import org.nogin.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("User", User.class);
        System.out.println(user);
        context.close();
    }
}
