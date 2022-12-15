package com.codewithravikiran.blog.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.codewithravikiran.blog.payloads.APIResponse;
import com.codewithravikiran.blog.payloads.CategoryDto;
import com.codewithravikiran.blog.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	// create

	@Autowired
	CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> crateCategory(@Valid @RequestBody CategoryDto categoryDto) {

		CategoryDto CrateCategory = this.categoryService.crateCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(CrateCategory, HttpStatus.CREATED);
	}

	// update
	@PutMapping("{catId}")
	public ResponseEntity<CategoryDto> updateeCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("catId") Integer catId ) {

		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto,catId);

		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("{catId}")
	public ResponseEntity<APIResponse> deleteCategory(@PathVariable("catId") Integer catId ) {
		this.categoryService.deleytecategory(catId);
		return new ResponseEntity<APIResponse>(new APIResponse("catergory is delted !!", true),HttpStatus.OK);
	}

	// get
	
	@GetMapping("{catId}")
	public ResponseEntity<CategoryDto> getCategory(@RequestBody CategoryDto categoryDto,@PathVariable("catId") Integer catId ) {
		CategoryDto categoryDto2 = this.categoryService.getCategory(catId);
		return  new ResponseEntity<CategoryDto>(categoryDto2,HttpStatus.OK); 
		
	}
	
	// getAll
	@GetMapping("")
	public ResponseEntity<List<CategoryDto>> getCategory() {
		List<CategoryDto> allCategorys = this.categoryService.getAllCategorys();
		return  ResponseEntity.ok(allCategorys); 
	}

}
