package com.lis.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@ComponentScan("com.lis.exam")
public class RedisConfiguration {
	
	@Bean
	public JedisConnectionFactory getJedisConnectionFactory() {
		//runs in default setting
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Object> getRedisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(getJedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
		return template;
	}

}
