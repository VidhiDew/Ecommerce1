package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testGetProductById_Success() {
        Product product = new Product(1L, "Laptop", "HP Laptop", 55000.0);
        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        ProductDTO dto = productService.getProductById(1L);

        assertEquals("Laptop", dto.getName());
        verify(productRepo, times(1)).findById(1L);
    }

    @Test
    void testGetProductById_NotFound() {
        when(productRepo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> productService.getProductById(1L));
    }
}

