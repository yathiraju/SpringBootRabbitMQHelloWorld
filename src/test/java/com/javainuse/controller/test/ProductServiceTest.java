package com.javainuse.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.javainuse.repo.ProductRepository;
import com.javainuse.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	ProductService productService;

	@Mock
	ProductRepository productRepository;

	@Test
	public void testProductCount() {

		Mockito.when(productRepository.count()).thenReturn(new Long(10));
		assertEquals(new Long(10), productService.getProductCount());

	}

}
