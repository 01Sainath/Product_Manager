package com.app.controller;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.app.dto.ProductDto;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService prodServ;
	
	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		
		ResponseEntity resp;
		try{
			resp = new ResponseEntity(prodServ.getAll(), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity("Some error occured", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@GetMapping("/type/{type_name}")
	public ResponseEntity<?> getByType(@PathVariable Category type_name){
		return new ResponseEntity(prodServ.getByType(type_name), HttpStatus.OK);
	}
	
	@PostMapping("/{user_id}")
	public ResponseEntity<?> addProduct(@RequestBody @NotNull ProductDto prod, @NotNull @PathVariable int user_id) {

		return new ResponseEntity(prodServ.add(prod, user_id), HttpStatus.CREATED);
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<?> getByUserId(@PathVariable Integer user_id){
		return new ResponseEntity(prodServ.getByUserId(user_id), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateProduct(@RequestBody @NotNull ProductDto prod) {
		return new ResponseEntity(prodServ.updateProduct(prod), HttpStatus.OK);
	}
}
