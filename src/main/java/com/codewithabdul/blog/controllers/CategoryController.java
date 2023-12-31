package com.codewithabdul.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithabdul.blog.payloads.ApiResponse;
import com.codewithabdul.blog.payloads.CategoryDto;
import com.codewithabdul.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apis/categories")

public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory( @Valid @RequestBody CategoryDto catDto){
		System.out.println("In CategoryController");
		
		CategoryDto createCategory= this.categoryService.createCategory(catDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid CategoryDto categoryid ,@PathVariable Integer userId  ){
		CategoryDto updateCategory=this.categoryService.updateCategory(categoryid, userId);
		
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{uId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer uId){
		this.categoryService.deleteCategory(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(),HttpStatus.OK);
		
	}
 
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
		CategoryDto categoryDto=this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
		
		
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>>getCategories(){
		List<CategoryDto> categories=this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
		
		
	}
	
}
