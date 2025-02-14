package com.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.training.domain.Product;

@Repository
public class ProductDAOInMemImpl implements ProductDAO {
	
	Map<Integer,Product> db = new ConcurrentHashMap<>(); //HashMap is not thread-safe , so CHM
	AtomicInteger idSequence = new AtomicInteger(0); //int ++ is not thread-safe, so AtomicInteger
	
	@Override
	public Product save(Product toBeSaved) {
		int id = idSequence.incrementAndGet();
		toBeSaved.setId(id);
		db.put(id, toBeSaved);
		return toBeSaved;
	}
	
	@Override
	public Product findById(int id) {
		return db.get(id);
	}
	
	@Override
	public List<Product> findAll() {
		return new ArrayList<>(db.values());
	}
	
	@Override
	public void deleteById(int id) {
		db.remove(id);
		
	}
	

	
}
