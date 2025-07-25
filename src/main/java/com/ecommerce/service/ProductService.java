package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductDTO;

public interface ProductService {

	ProductDTO addProduct(ProductDTO productDTO);
	
    List<ProductDTO> getAllProducts();
    
    ProductDTO getProductById(Long id);
    
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    
    void deleteProduct(Long id);
    
    List<ProductDTO> searchProducts(String name);
}
