package cn.com.taiji.redis.test.controller;


import cn.com.taiji.redis.test.model.User;
import cn.com.taiji.redis.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
    public User getUser(String id){
		User user = userService.getUser(id);
		return user;
    }
	
	@RequestMapping("/deleteUser")
	public String deleteUser(String id){
		userService.deleteUser(id);
		return "执行删除";
	}

	@RequestMapping("/putUser")
	public User putUser(String id){
		User user = userService.putUser(id);
		return user;
	}

	@RequestMapping("/getUserNokey")
	public User getUserNokey(String id){
		User user = userService.getUserNokey(id);
		return user;
	}
	

}
