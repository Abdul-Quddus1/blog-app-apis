package com.codewithabdul.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithabdul.blog.entities.Category;
import com.codewithabdul.blog.exceptions.ResourceNotFoundException;
import com.codewithabdul.blog.payloads.CategoryDto;
import com.codewithabdul.blog.repositories.CategoryRepo;
import com.codewithabdul.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	//create....................
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addcat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addcat, CategoryDto.class);
	}
	
	
    
	//update......................
	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category", "categoryId",categoryId));
		
		//cat.setCategoryTitle(categoryDto.getCategoryTitle());
		//cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatecat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatecat, CategoryDto.class);
	}

	//delete..................
	@Override
	public void deleteCategory(Integer categoryId) {

		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "Category id", categoryId));
		this.categoryRepo.delete(cat);
		
	}

	//Get Single category...................
	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	//Get Category in list.................
	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories= this.categoryRepo.findAll();
		List<CategoryDto>catdtos=categories.stream().
				map((cat)->this. modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catdtos;
	}


	
}
