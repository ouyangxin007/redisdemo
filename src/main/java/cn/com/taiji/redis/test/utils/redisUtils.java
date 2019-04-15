package cn.com.taiji.redis.test.utils;

import cn.com.taiji.redis.test.model.User;
import cn.com.taiji.redis.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class redisUtils {
    @Autowired
    private UserService userService;

    public  User changeUserUtil(String id,String age){
        userService.deleteUser(Integer.valueOf(id));
        userService.getUserChangeAge(id,age);
        return null;
    }
}
