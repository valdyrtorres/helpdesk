package com.valdyrtorres.helpdesk.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.valdyrtorres.helpdesk.api.entity.User;
import com.valdyrtorres.helpdesk.api.repository.UserRepository;
import com.valdyrtorres.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findById(String Id) {
		return this.userRepository.findOne(Id);
		//return this.userRepository.findById(Id);
	}

	@Override
	public void delete(String id) {
		this.userRepository.delete(id);
		
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages = (Pageable) new PageRequest(page, count);
		return (Page<User>) this.userRepository.findAll((Sort) pages);
		//return this.userRepository.findAll(PageRequest.of(page, count));
	}

}
