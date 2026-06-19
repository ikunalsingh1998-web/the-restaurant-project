package com.kunal.restaurant.Services;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisService<T> {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void saveToRedis(String key, Object value, Long ttl) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String valueJson = mapper.writeValueAsString(value);
			redisTemplate.opsForValue().set(key, valueJson, ttl, TimeUnit.SECONDS);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public List<T> getFromRedis(String key, TypeReference<List<T>> typeReference) {
		try {
			String objJson = (String) redisTemplate.opsForValue().get(key);
			if (objJson != null) {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(objJson, typeReference);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
