package cn.com.taiji.redis.test.service;


import cn.com.taiji.redis.test.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

public interface UserService {
	
	@Cacheable(value="users", key="'user_'+#id")
	User getUser(String id);
	/**
	 * 删除某些特定条件下的用户
	 * @param id
	 */
//	@CacheEvict(value="users", key="'user_'+#id",condition="#id!=1")
//	void deleteUser(int id);

	@CacheEvict(value="users", condition="#id!=1")
	void deleteUser(int id);

	@CachePut(value="users")
	User putUser(String id);

	@Cacheable(value="users")
	@Caching(put = {
			@CachePut(value = "user", key = "'user_'+#id"),
			@CachePut(value = "user", key = "'user_'+#age")
	})
	User getUserNokey(String id,String age);

	@Cacheable(value="users", key="'user_'+#id")
	@Caching(put = {
			@CachePut(value = "user", key = "'user_'+#id"),
			@CachePut(value = "user", key = "'user_'+#age")
	})
	User getUserChangeAge(String id,String age);

	@Cacheable(value="users", key="'user_'+#id")
	User getUserChangeAgeInside(String id,String age);





}
