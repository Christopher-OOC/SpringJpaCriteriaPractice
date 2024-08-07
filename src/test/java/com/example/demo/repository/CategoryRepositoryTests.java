package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.model.entity.Category;
import com.example.demo.utils.PublicIdGeneratorUtils;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTests {
	
	private String categoryName = "Spices";
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void createIngredient() {
		Category category = new Category();
		category.setCategoryId(PublicIdGeneratorUtils.generatePublicId(30));
		category.setCategoryName(categoryName);
		
		Category savedCategory = categoryRepository.save(category);
		
		assertNotNull(savedCategory);
	}

}
