package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.service.ProviderService;

@RestController
@RequestMapping("/provider")
public class ProviderController {
	
	@Autowired
	ProviderService providerServ;
	
	@DeleteMapping("/{id}")
	public String deleteProvider(@PathVariable Integer id) {
		return providerServ.delete(id);
	}

	@GetMapping
	public List<User> getAll(){
		return providerServ.getAll();
	}
	
	@GetMapping("/{id}")
	public String getAUser(@PathVariable Integer id) {
		return providerServ.get(id);
	}
}
