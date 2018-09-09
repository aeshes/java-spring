package service;

import data.User;
import data.UserDataRepository;
import data.UserDataRepositoryImpl;

public class UserService {

    private UserDataRepository udr;

    public UserService(UserDataRepository udr) {
        this.udr = udr;
    }

    public void persistUser(User user) {
        udr.save(user);
    }
}
