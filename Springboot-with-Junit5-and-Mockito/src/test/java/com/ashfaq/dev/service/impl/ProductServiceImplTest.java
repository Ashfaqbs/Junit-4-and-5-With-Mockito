package com.ashfaq.dev.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ashfaq.dev.model.Product;
import com.ashfaq.dev.repository.ProductRepository;

public class ProductServiceImplTest {
	
//  Mocking: Using Mockito to mock dependencies and stub methods.
//  Assertions: Using JUnit assertions to verify the results.
//  Verification: Using Mockito to verify interactions with mocks.

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateProduct() {
		// Arrange
		Product newProduct = new Product();
		newProduct.setName("Laptop");
		newProduct.setPrice(999.99);

		when(productRepository.save(any(Product.class))).thenReturn(newProduct);
		// Mocks the save method to return the newProduct when called with any Product.

		// Act
		Product createdProduct = productService.createProduct(newProduct);// Calls the method being tested.

		// Assert
		assertNotNull(createdProduct);// : Checks that the product is not null.
		assertEquals("Laptop", createdProduct.getName());// : Checks that the name is "Laptop".
		assertEquals(999.99, createdProduct.getPrice());// : Checks that the price is 999.99.
	}

	@Test
	public void testGetProductById() {

//    	Arrange: A Product instance is created with specific fields.
//    	Mocking: The findById method of the productRepository mock is stubbed to return an Optional containing the product when called with productId.
//    	Act: The getProductById method of the productService is called.
//    	Assert: The test checks that the retrieved product is not null and its fields match the expected values.

		// Arrange
		Long productId = 1L;
		Product product = new Product();
		product.setId(productId);
		product.setName("Phone");
		product.setPrice(499.99);

		when(productRepository.findById(productId)).thenReturn(Optional.of(product));

		// Act
		Product retrievedProduct = productService.getProductById(productId);

		// Assert
		assertNotNull(retrievedProduct);
		assertEquals("Phone", retrievedProduct.getName());
		assertEquals(499.99, retrievedProduct.getPrice());
	}

	@Test
	public void testGetAllProducts() {

//    	Arrange: A Product instance is created and added to a list.
//    	Mocking: The findAll method of the productRepository mock is stubbed to return a list containing the product.
//    	Act: The getAllProducts method of the productService is called.
//    	Assert: The test checks that the size of the returned list is 1 and the fields of the product in the list match the expected values.

		// Arrange
		Product product = new Product();
		product.setId(1L);
		product.setName("Tablet");
		product.setPrice(299.99);

		when(productRepository.findAll()).thenReturn(Collections.singletonList(product));

		// Act
		List<Product> productList = productService.getAllProducts();

		// Assert
		assertEquals(1, productList.size());
		assertEquals("Tablet", productList.get(0).getName());
		assertEquals(299.99, productList.get(0).getPrice());
	}

	@Test
	public void testUpdateProduct() {

//    	Arrange: Existing and updated Product instances are created.
//    	Mocking:
//    	The existsById method of the productRepository mock is stubbed to return true when called with productId.
//    	The save method of the productRepository mock is stubbed to return the updated product.
//    	Act: The updateProduct method of the productService is called.
//    	Assert: The test checks that the returned product is not null and its fields match the expected values.

		// Arrange
		Long productId = 1L;
		Product existingProduct = new Product();
		existingProduct.setId(productId);
		existingProduct.setName("Smartwatch");
		existingProduct.setPrice(199.99);

		Product updatedProduct = new Product();
		updatedProduct.setName("Fitness Tracker");
		updatedProduct.setPrice(149.99);

		when(productRepository.existsById(productId)).thenReturn(true);
		when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);

		// Act
		Product result = productService.updateProduct(productId, updatedProduct);

		// Assert
		assertNotNull(result);
		assertEquals("Fitness Tracker", result.getName());
		assertEquals(149.99, result.getPrice());
	}

	@Test
	public void testDeleteProduct() {

//    	Arrange: The ID of the product to be deleted is defined.
//    	Act: The deleteProduct method of the productService is called.
//    	Assert: The test verifies that the deleteById method of the productRepository mock was called exactly once with productId.

		// Arrange
		Long productId = 1L;

		// Act
		productService.deleteProduct(productId);

		// Assert
		verify(productRepository, times(1)).deleteById(productId);
	}
//    Mocking: Using Mockito to mock dependencies and stub methods.
//    Assertions: Using JUnit assertions to verify the results.
//    Verification: Using Mockito to verify interactions with mocks.
    @Test
    public void testGetProductsByName() {
    	
//    	Purpose: To verify that products can be fetched by name.
//    	Arrange: Set up a product with the name "Laptop".
//    	Mocking: The findByName method of the productRepository is stubbed to return a list containing the product.
//    	Act: Call getProductsByName on the service.
//    	Assert: Verify the returned list size and product details.
        // Arrange
        String name = "Laptop";
        Product product = new Product();
        product.setName(name);
        product.setPrice(999.99);

        when(productRepository.findByName(name)).thenReturn(Collections.singletonList(product));

        // Act
        List<Product> products = productService.getProductsByName(name);

        // Assert
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
        assertEquals(999.99, products.get(0).getPrice());
    }

    @Test
    public void testGetProductsByPriceRange() {
    	
//    	Purpose: To verify that products can be fetched by a price range.
//    	Arrange: Set up a product with a price within the range.
//    	Mocking: The findByPriceBetween method of the productRepository is stubbed to return a list containing the product.
//    	Act: Call getProductsByPriceRange on the service.
//    	Assert: Verify the returned list size and product details.
    	
    	
        // Arrange
        Double minPrice = 500.0;
        Double maxPrice = 1000.0;
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(999.99);

        when(productRepository.findByPriceBetween(minPrice, maxPrice)).thenReturn(Collections.singletonList(product));

        // Act
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);

        // Assert
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
        assertEquals(999.99, products.get(0).getPrice());
    }


//    
//    Annotations:
//
//    	@Mock: Creates a mock instance of ProductRepository.
//    	@InjectMocks: Injects the mock instances into ProductServiceImpl.
//    	@BeforeEach: Initializes the mocks before each test.
//    	Stubbing:
//
//    	when(productRepository.save(any(Product.class))).thenReturn(newProduct): 
//    	This line tells Mockito to return newProduct when save is called on the productRepository mock with any Product object.
//    	Verification:
//
//    	verify(productRepository, times(1)).deleteById(productId): This line checks that the deleteById method on 
//    	productRepository was called exactly once with productId.
}
