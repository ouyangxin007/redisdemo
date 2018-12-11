package cn.com.taiji.redis.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@Autowired
	private StringRedisTemplate template;
    
    @RequestMapping("/setValue")
    public String setValue(){
    	if(!template.hasKey("testkey")){
    		template.opsForValue().append("testkey", "testvalue");
    		return "使用redis缓存保存数据成功";
    	}else{
    		template.delete("testkey");
    		return "key已存在";
    	}
    }
    
    @RequestMapping("/getValue")
    public String getValue(){
    	
    	if(!template.hasKey("testkey")){
    		return "key不存在，请先保存数据";
    	}else{
    		String testkey = template.opsForValue().get("testkey");//根据key获取缓存中的val
    		return "获取到缓存中的数据：testkey="+testkey;
    	}
    }
    @RequestMapping("/delValue")
    public String delValue(){
    	
    	if(template.hasKey("testkey")){
    		template.delete("testkey");
    	}
    	return "删除成功";

    }

}