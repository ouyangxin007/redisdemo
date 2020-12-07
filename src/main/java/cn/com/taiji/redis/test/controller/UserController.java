package cn.com.taiji.redis.test.controller;


import cn.com.taiji.redis.test.model.User;
import cn.com.taiji.redis.test.service.UserService;
import cn.com.taiji.redis.test.utils.redisUtils;
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
		int idInteget = Integer.valueOf(id);
		userService.deleteUser(idInteget);
		return "执行删除";
	}

	@RequestMapping("/putUser")
	public User putUser(String id){
		User user = userService.putUser(id);
		return user;
	}

	@RequestMapping("/getUserNokey")
	public User getUserNokey(String id,String age){
		User user = userService.getUserNokey(id,age);
		return user;
	}

	@RequestMapping("/changeUser")
	public User changeUser(String id,String age){
		userService.deleteUser(Integer.valueOf(id));
		User user = userService.getUserChangeAge(id,age);
		return user;
	}

	@RequestMapping("/changeUserInside")
	public User changeUserInside(String id,String age){
		User user = userService.getUserChangeAgeInside(id,age);
		return user;
	}


	

}
