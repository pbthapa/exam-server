package com.lis.exam.redis.repository.Impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.lis.exam.entity.SubjectArea;
import com.lis.exam.redis.repository.SubjectAreaRedisRepository;

@Repository
public class SubjectAreaRedisRepositoryImpl implements SubjectAreaRedisRepository {

	private RedisTemplate<String, Object> redisTemplate;
	//hash, hashkey, hashvalue
	private HashOperations<String, Long, SubjectArea> hashOperations;
	
	private static final String KEY = "SUBJECT";
	
	@Autowired
	public SubjectAreaRedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
    @PostConstruct
    private void init() {
    	hashOperations = redisTemplate.opsForHash();
    }
	
	@Override
	public void save(SubjectArea entity) {
		hashOperations.put(KEY, entity.getId(), entity);
	}

	@Override
	public void update(SubjectArea entity) {
		hashOperations.put(KEY, entity.getId(), entity);
	}

	@Override
	public void delete(Long id) {
		hashOperations.delete(KEY, id);
	}

	@Override
	public SubjectArea find(Long id) {
		return (SubjectArea) hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, SubjectArea> findAll() {
		return hashOperations.entries(KEY);
	}

}
