package com.app.service;

import java.util.List;

import com.app.entities.User;

public interface ProviderService {

	public String delete(Integer id);

	public List<User> getAll();
	
	
}
