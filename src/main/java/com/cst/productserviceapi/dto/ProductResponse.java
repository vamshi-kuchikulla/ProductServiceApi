package com.cst.productserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
//    @NotBlank
//    @Min(value = 1, message = "product ID can't be less than 1")
//    @Max(value = 2147483647, message = "product ID can't be more than 2147483647")
    private int id;
    private String name;
    private String desc;
    private long price;
}

