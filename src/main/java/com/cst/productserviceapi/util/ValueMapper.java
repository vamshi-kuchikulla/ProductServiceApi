package com.cst.productserviceapi.util;

import com.cst.productserviceapi.dto.ProductRequest;
import com.cst.productserviceapi.dto.ProductResponse;
import com.cst.productserviceapi.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValueMapper {

    public static Product convertToEntity(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDesc(productRequest.getDesc());
        product.setPrice(productRequest.getPrice());
         return product;
    }

    public static ProductResponse convertToDto(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDesc(product.getDesc());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public static String jsonToString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
