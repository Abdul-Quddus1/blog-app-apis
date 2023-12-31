package com.codewithabdul.blog.services;

import java.util.List;

import com.codewithabdul.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//Cereate
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	
	void deleteCategory(Integer categoryId);
	
	
	//get
	
	CategoryDto getCategory(Integer categoryId);
	
	
	//getAll
	
	List<CategoryDto>getCategories();

}
