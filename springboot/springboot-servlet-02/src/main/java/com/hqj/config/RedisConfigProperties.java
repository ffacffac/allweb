package com.hqj.config;

import static org.mockito.Matchers.contains;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 通过application.properties配置redis的配置
 *
 */
@Configuration
public class RedisConfigProperties {

	/**
	 * 1.创建 JedisPoolConfig 对象。 在该对象中完成一些链接池配置
	 * 
	 * @ConfigurationProperties:会将application.properties文件前缀相同的内容创建一个实体。
	 * 
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.redis.pool")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();

//		// 最大空闲数
//		config.setMaxIdle(10);
//		// 最小空闲数
//		config.setMinIdle(5);
//		// 最大链接数
//		config.setMaxTotal(20);

		return config;
	}

	/***
	 * 2.
	 * 
	 * 创建 JedisConnectionFactory： 配置 redis 链接信息
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPoolConfig(config);

		System.out.println(config.toString());

//		// 配置链接 Redis 的信息
//		// 主机地址
//		factory.setHostName("127.0.0.1");
//		// 端口
//		factory.setPort(6379);

		return factory;
	}

	/***
	 * 3.创建 RedisTemplate:用于执行 Redis 操作的方法
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		// 关联
		template.setConnectionFactory(factory);
		// 为key设置序列化器
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}
}
