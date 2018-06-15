package com.valdyrtorres.helpdesk.api.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import com.valdyrtorres.helpdesk.api.entity.User;

public interface UserService {

	User findByEmail(String email);
	
	User createOrUpdate(User user);
	
	Optional<User> findById(String Id);
	
	void delete(String id);
	
	Page<User> findAll(int page, int count);
	
}
