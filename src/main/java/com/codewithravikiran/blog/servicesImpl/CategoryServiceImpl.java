package com.codewithravikiran.blog.servicesImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithravikiran.blog.entities.Category;
import com.codewithravikiran.blog.exception.ResourceNotFoundException;
import com.codewithravikiran.blog.payloads.CategoryDto;
import com.codewithravikiran.blog.repository.CategoryRepo;
import com.codewithravikiran.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto crateCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto,Category.class );
		Category category2 = this.categoryRepo.save(category);
		return this.modelMapper.map(category2, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId).
		orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatecategory = this.categoryRepo.save(category);
		
		return this.modelMapper.map(updatecategory, CategoryDto.class); 
	}

	@Override
	public void deleytecategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).
		orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategorys() {
		List<Category> listCategoryies = this.categoryRepo.findAll();
		// we can pass this as list beacuse we have to List<CategoryDto>
		//we can use map by using stram API
		List<CategoryDto> listDTo = listCategoryies.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return listDTo;
	}

	

	

}
