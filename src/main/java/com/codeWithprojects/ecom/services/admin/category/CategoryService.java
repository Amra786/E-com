package com.codeWithprojects.ecom.services.admin.category;

import java.util.List;

import com.codeWithprojects.ecom.dto.CategoryDto;
import com.codeWithprojects.ecom.entity.Category;

public interface CategoryService {
	
	Category createcategory(CategoryDto categoryDto);
	List<Category> getAllCategories();
}
