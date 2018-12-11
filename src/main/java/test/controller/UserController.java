package test.controller;

import com.redis.test.model.User;
import com.redis.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
    public User getUser(){
		User user = userService.getUser("testuser");
		return user;
    }
	
	@RequestMapping("/deleteUser")
	public String deleteUser(){
		userService.deleteUser("testuser");
		return "执行删除";
	}
	
	

}
