package com.javainuse.controller.test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.javainuse.controller.ProductController;
import com.javainuse.model.Product;
import com.javainuse.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerSpringRunnerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	ProductService productService;

	@Test
	public void getProducts() throws Exception {
		Product product = new Product();
		product.setId(1);
		product.setName("mobile");
		List<Product> products = Arrays.asList(product);
		given(productService.getProducts()).willReturn(products);
		mvc.perform(get("/api/allproducts").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name", is("mobile")));
		
		/* andExpect(content().json("[{'id': 1,'name': 'Stock 1';'price': 1}]")); */

	}

}
