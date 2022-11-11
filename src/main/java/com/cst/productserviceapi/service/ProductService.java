package com.cst.productserviceapi.service;

import com.cst.productserviceapi.dto.ProductRequest;
import com.cst.productserviceapi.dto.ProductResponse;
import com.cst.productserviceapi.model.Product;
import com.cst.productserviceapi.repository.ProductRepository;
import com.cst.productserviceapi.util.ValueMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(ProductRequest productRequest) {
        Product product = ValueMapper.convertToEntity(productRequest);
        return productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ValueMapper::convertToDto).collect(Collectors.toList());
    }

    public ProductResponse getProductById(int id) {
        Product product = productRepository.findById(id).orElse(null);
        return ValueMapper.convertToDto(product);
    }
}
