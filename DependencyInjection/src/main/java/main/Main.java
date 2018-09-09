package main;

import data.User;
import service.UserService;
import service.UserServiceFactory;

public class Main {
    public static void main(String[] args) {
        UserServiceFactory factory = new UserServiceFactory();
        UserService service = factory.getInstance();
        service.persistUser(new User("lol"));
    }
}
