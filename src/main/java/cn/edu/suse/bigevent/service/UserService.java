package cn.edu.suse.bigevent.service;

import cn.edu.suse.bigevent.pojo.User;

public interface UserService {

    //根据用户名查询
    User findByUserName(String username);
    //注册用户
    void register(String username, String password);
}
