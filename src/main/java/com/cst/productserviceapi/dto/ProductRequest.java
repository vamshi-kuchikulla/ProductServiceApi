package com.cst.productserviceapi.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductRequest {
    @NotBlank(message = "product type shouldn't be NULL OR EMPTY")
    private String name;
    @NotBlank(message = "Description shouldn't be NULL OR EMPTY")
    private String desc;
    @Min(value = 200, message = "product price can't be less than 200")
    @Max(value = 500000, message = "product price can't be more than 5000")
    private long price;
}
