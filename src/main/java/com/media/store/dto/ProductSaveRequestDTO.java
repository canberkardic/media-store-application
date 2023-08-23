package com.media.store.dto;

import com.media.store.entity.BaseProduct;
import lombok.Data;

@Data
public class ProductSaveRequestDTO<T> {
    private String productType;
    private T product;

}
