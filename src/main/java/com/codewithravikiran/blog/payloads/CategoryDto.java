package com.codewithravikiran.blog.payloads;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class CategoryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer categoryId;

	@NotBlank
	@Size(min = 4,message = "min size of the category title is 4")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10,message = "min size of category desce is 10")
	private String categoryDescription;
	

}
