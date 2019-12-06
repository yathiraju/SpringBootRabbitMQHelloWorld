package com.javainuse.controller.test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javainuse.SpringBootHelloWorldApplication;
import com.javainuse.model.Product;
import com.javainuse.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootHelloWorldApplication.class)
@WebAppConfiguration
public class ProductControllerTest {

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@MockBean
	ProductService productService;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getProducts() throws Exception {
		Product product = new Product();
		product.setId(1);
		product.setName("mobile");
		List<Product> products = Arrays.asList(product);
		given(productService.getProducts()).willReturn(products);
		mvc.perform(get("/api/allproducts").contentType(MediaType.APPLICATION_JSON))/* .andExpect(status().isOk()) */
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name", is("mobile")));

		/* andExpect(content().json("[{'id': 1,'name': 'Stock 1';'price': 1}]")); */

	}

}
