package cn.com.taiji.redis.test.serviceImpl;


import cn.com.taiji.redis.test.model.User;
import cn.com.taiji.redis.test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String id) {
		System.out.println(id+"进入实现类获取数据！");
		User user = new User();
		user.setId(id);
		user.setName("testuser");
		user.setAge(18);
		return user;
	}

	@Override
	public void deleteUser(String id) {
		System.out.println(id+"进入实现类删除数据！");
	}

	@Override
	public User putUser(String id) {//每次都会执行
		System.out.println(id+"进入实现类获取数据！");
		User user = new User();
		user.setId(id);
		user.setName("testuserput");
		user.setAge(20);
		return user;
	}

	@Override
	public User getUserNokey(String id) {
		System.out.println(id+"进入实现类获取数据！");
		User user = new User();
		user.setId(id);
		user.setName("testuser");
		user.setAge(18);
		return user;
	}
}
