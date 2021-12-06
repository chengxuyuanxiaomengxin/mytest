package edu.soft1.service;

import edu.soft1.pojo.User;

public interface LoginService {
    public User validate(String username,String upwd);
}
