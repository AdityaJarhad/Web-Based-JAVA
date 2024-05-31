package com.blogs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.CategoryDTO;

@SpringBootTest 
class CategoryServiceTest {
	@Autowired
	private CategoryService categoryService;

	@Test
	void test() {
		assertNotNull(categoryService);
	}
	@Test
	void testGetAllCategories() {
		List<CategoryDTO> list = categoryService.getAllCategories();
		assertEquals(3, list.size());
		list.forEach(l -> System.out.println(l));
	}

}
