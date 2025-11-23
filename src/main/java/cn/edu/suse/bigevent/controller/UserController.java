package cn.edu.suse.bigevent.controller;


import cn.edu.suse.bigevent.pojo.Result;
import cn.edu.suse.bigevent.pojo.User;
import cn.edu.suse.bigevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username,String password){
        //查询用户
        User u = userService.findByUserName(username);
        //注册用户
        if(u == null){
            userService.register(username,password);
            return Result.success();
        }else {
            return Result.error("用户名已被占用");
        }
    }

}
