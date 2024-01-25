package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public List<String> home() {
		List<String> msgs = new ArrayList<>();
		
		msgs.add("Hello World, I'm Sainath...");
		msgs.add("/products (GET) -> to get all the products");
		msgs.add("/products/type/{type_name} (GET) -> to get all the products by type");
		msgs.add("/products/{user_id} (POST) -> to Add a product, send the data via body");
		msgs.add("/products/{user_id} (GET) -> to get all products provided by a provider");
		msgs.add("/products (PUT) -> to update a product, Send the data via body");
		
		msgs.add("/provider (GET) -> to get all the providers");
		msgs.add("/provider/{id} (DELETE) -> to delete a particular provider based on the id");
		return msgs;
	}
}
