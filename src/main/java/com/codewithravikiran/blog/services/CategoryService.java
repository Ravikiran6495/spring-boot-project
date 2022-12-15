package com.codewithravikiran.blog.services;

import java.util.List;

import com.codewithravikiran.blog.payloads.CategoryDto;

public interface CategoryService {

	
	//create
	public CategoryDto crateCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId); 
	
	//delete
	public void deleytecategory(Integer categoryId);
	
	// get
	public CategoryDto getCategory(Integer categoryId);
	
	//getAll
	public List<CategoryDto> getAllCategorys();
	
}
