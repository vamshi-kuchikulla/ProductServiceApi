package com.cst.productserviceapi.controller;

import com.cst.productserviceapi.dto.APIResponse;
import com.cst.productserviceapi.dto.ProductRequest;
import com.cst.productserviceapi.dto.ProductResponse;
import com.cst.productserviceapi.model.Product;
import com.cst.productserviceapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ProductController {
    public static final String SUCCESS = "Success";
    private final ProductService productService;

    /**
     * \
     * @param productRequest
     * @return
     */
    @PostMapping(value = "/addProduct")
    public ResponseEntity<APIResponse> addProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.addProduct(productRequest);
        APIResponse<Product> productDTO = APIResponse.<Product>builder()
                .status(SUCCESS)
                .results(product)
                .build();
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/getAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<APIResponse> getAllProducts() {

        List<ProductResponse> allProducts = productService.getAllProducts();
        APIResponse<List<ProductResponse>> productsDTO = APIResponse.<List<ProductResponse>>builder()
                .status(SUCCESS)
                .results(allProducts)
                .build();

        return new ResponseEntity<>(productsDTO,HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getProductById/{id}")
    public ResponseEntity<APIResponse> getProductById(@PathVariable int id) {
        ProductResponse productById = productService.getProductById(id);
        APIResponse<ProductResponse> productDto = APIResponse.<ProductResponse>builder()
                .status(SUCCESS)
                .results(productById)
                .build();
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
//        return ResponseEntity.created(location).build();
}
