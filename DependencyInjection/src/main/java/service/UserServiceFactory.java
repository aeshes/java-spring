package service;

import data.UserDataRepositoryImpl;

public class UserServiceFactory {

    public UserService getInstance() {
        return new UserService(new UserDataRepositoryImpl());
    }
}
