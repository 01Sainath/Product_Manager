package com.app.service;

import java.util.List;

import com.app.dto.ProductDto;
import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductService {
	public List<ProductDto> getAll();

	public List<ProductDto> getByType(Category type_name);

	public String add(ProductDto prod, int user_id);

	public List<ProductDto> getByUserId(Integer user_id);

	public String updateProduct(ProductDto prod);
}
