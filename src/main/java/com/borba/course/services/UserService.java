package com.borba.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borba.course.entities.User;
import com.borba.course.repositories.UserRepository;
import com.borba.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update (Long id, User obj) {
		Optional<User> entity = repository.findById(id);
		updateData(entity, obj);
		return repository.save(entity.get());
		
	}

	private void updateData(Optional<User> entity, User obj) {
		entity.get().setName(obj.getName());
		entity.get().setEmail(obj.getEmail());
		entity.get().setPhone(obj.getPhone());
		
	}
}

