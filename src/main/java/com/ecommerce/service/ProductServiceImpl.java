package com.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	
	private ProductDTO convertToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
	    dto.setId(product.getPid());
	    dto.setName(product.getName());
	    dto.setDescription(product.getDescription());
	    dto.setPrice(product.getPrice());
	    dto.setQuantity(product.getQuantity());
	    return dto;
	}
	
	private Product convertToEntity(ProductDTO dto) {
		Product product = new Product();
		product.setPid(dto.getId());
	    product.setName(dto.getName());
	    product.setDescription(dto.getDescription());
	    product.setPrice(dto.getPrice());
	    product.setQuantity(dto.getQuantity());
	    return product;
	}

	@Override
	public ProductDTO addProduct(ProductDTO dto) {
		Product saved = productRepo.save(convertToEntity(dto));
		return convertToDTO(saved);
	}
	
	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepo.findAll()
						  .stream()
						  .map(this::convertToDTO)
						  .collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
		return convertToDTO(product);
	}
	
	@Override
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
		
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		
		return convertToDTO(productRepo.save(product));
	}

	@Override
	public void deleteProduct(Long id) {
		if (!productRepo.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        productRepo.deleteById(id);
		
	}

	@Override
	public List<ProductDTO> searchProducts(String name) {
		return productRepo.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
	}

}
