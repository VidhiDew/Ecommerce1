package com.ecommerce.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
		return new ResponseEntity<>(productService.addProduct(productDTO), HttpStatus.CREATED);
	}
	
	 @GetMapping
	    public ResponseEntity<List<ProductDTO>> getAllProducts() {
	        return ResponseEntity.ok(productService.getAllProducts());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
	        return ResponseEntity.ok(productService.getProductById(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO dto) {
	        return ResponseEntity.ok(productService.updateProduct(id, dto));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/search")
	    public ResponseEntity<List<ProductDTO>> searchProduct(@RequestParam String name) {
	        return ResponseEntity.ok(productService.searchProducts(name));
	    }
}
