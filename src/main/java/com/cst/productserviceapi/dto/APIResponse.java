package com.cst.productserviceapi.dto;

import com.cst.productserviceapi.exceptionHandler.CustomError;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {
    private String status;
    private List<CustomError> errors;
    private T results;
}
