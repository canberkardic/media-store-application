package com.media.store.service;

import com.media.store.dto.ProductSaveRequestDTO;
import com.media.store.dto.PurchaseDTO;
import com.media.store.entity.BaseProduct;

import java.util.List;

public interface ProductService {
    List<BaseProduct> getAllProducts();

    Double purchaseAllProducts(PurchaseDTO products);

    String saveProduct(ProductSaveRequestDTO request);


}
