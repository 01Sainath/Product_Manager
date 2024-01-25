package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductDao;
import com.app.dao.UserDao;
import com.app.dto.ProductDto;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.User;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao pDao;
	
	@Autowired
	UserDao uDao;
	public List<ProductDto> getAll(){
		
		List<Product> list = pDao.findAll();
		List<ProductDto> prodDtos = new ArrayList<>();
		
		for(Product product: list) {
			ProductDto p = new ProductDto(product.getId(), product.getProductName(), product.getDescription(), product.getProductQuantity(), product.getPrice(), product.getCategory(), product.isInStock(), product.getProductionDate());
			prodDtos.add(p);
		}
		return prodDtos;
	}
	@Override
	public List<ProductDto> getByType(Category type_name) {
		
		List<Product> list = pDao.findByCategory(type_name);
		List<ProductDto> prodDtos = new ArrayList<>();
		
		for(Product product: list) {
			ProductDto p = new ProductDto(product.getId(), product.getProductName(), product.getDescription(), product.getProductQuantity(), product.getPrice(), product.getCategory(), product.isInStock(), product.getProductionDate());
			prodDtos.add(p);
		}
		return prodDtos;
	}
	@Override
	public String add(ProductDto prod, int user_id) {
		
		User u = uDao.findById(user_id).orElseThrow();
		Product p = new Product(prod.getProductName(),prod.getDescription(),prod.getProductQuantity(),prod.getPrice(), prod.getCategory(), prod.isInStock(), prod.getProductionDate(), u);
		u.getProducts().add(p);
		pDao.save(p);
		return "Check the product table";
	}
	@Override
	public List<ProductDto> getByUserId(Integer user_id) {
		
		User u = uDao.findById(user_id).orElseThrow();
		List<Product> list = pDao.findByProvider(u);
		List<ProductDto> prodDtos = new ArrayList<>();
		
		for(Product product: list) {
			ProductDto p = new ProductDto(product.getId(), product.getProductName(), product.getDescription(), product.getProductQuantity(), product.getPrice(), product.getCategory(), product.isInStock(), product.getProductionDate());
			prodDtos.add(p);
		}
		return prodDtos;
	}
	@Override
	public String updateProduct(ProductDto prod) {
		if(pDao.existsById(prod.getId())) {
			
			Product old = pDao.findById(prod.getId())
					.orElseThrow();
			int userId = old.getProvider().getUserId();
			
			User u = uDao.findById(userId).orElseThrow();
			
			Product p = new Product(prod.getProductName(),prod.getDescription(),prod.getProductQuantity(),prod.getPrice(), prod.getCategory(), prod.isInStock(), prod.getProductionDate(), u);			p.setId(prod.getId());
			pDao.save(p);
			return "product updated with id:"+prod.getId()+"User id: "+userId;
		}
		return "something went wrong";
	}
}
