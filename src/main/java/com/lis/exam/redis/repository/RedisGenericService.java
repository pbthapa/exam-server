package com.lis.exam.redis.repository;

import java.util.Map;

public interface RedisGenericService<T extends Object> {

	void save(T entity);
    
    void update(T entity);
  
    void delete(Long id);
  
    T find(Long id);
  
    Map<Long, T> findAll();
}
