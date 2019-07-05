package com.hqj.test;

import java.io.IOException;

import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hqj.App;
import com.hqj.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 测试redis
	 */
	@Test
	public void testRedisSet() {
		redisTemplate.opsForValue().set("name1", "李四1");
	}

	@Test
	public void testRedisGet() {
		String value = (String) this.redisTemplate.opsForValue().get("name");
		System.out.println("redis value is " + value);
	}

	/**
	 * 向redis添加实体类
	 */
	@Test
	public void testSaveUsers() {
		Users u = new Users();
		u.setUsername("redis保存实体类");
		u.setAddress("广州市");
		u.setUserage(20);
		u.setUserid(1);
		// 添加序列化设置，users才能保存到redis中
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.opsForValue().set("users", u);
	}

	/**
	 * 取实体类
	 */
	@Test
	public void testGetUsers() {
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users u = (Users) this.redisTemplate.opsForValue().get("users");
		System.out.println("username is " + u.getUsername());
	}

//	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 基于json格式保存users对象
	 * @throws IOException 
	 */
	@Test
	public void testSaveUsersJson() throws IOException {
		
		Users u = new Users();
		u.setUsername("redis  json保存实体类");
		u.setAddress("广州市json");
		u.setUserage(21);
		u.setUserid(2);

//		// 实体转json
//		String userJson = mapper.writeValueAsString(u);
//		System.out.println(userJson);
//		// json转实体
//		Users uJson=mapper.readValue(userJson, Users.class);
//		System.out.println(uJson.getUsername());

		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		this.redisTemplate.opsForValue().set("users_json", u);
	}

	/**
	 * 基于json获取users对象
	 */
	@Test
	public void testGetUsersJson() {
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users u = (Users) this.redisTemplate.opsForValue().get("users_json");
		System.out.println(u.getUsername());
	}
}
