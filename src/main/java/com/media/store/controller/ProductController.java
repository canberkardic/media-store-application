package com.media.store.controller;

import com.media.store.dto.ProductSaveRequestDTO;
import com.media.store.dto.PurchaseDTO;
import com.media.store.entity.BaseProduct;
import com.media.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<BaseProduct>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> createProduct(@RequestBody ProductSaveRequestDTO productToSave) {
        try {
            return new ResponseEntity<>(productService.saveProduct(productToSave), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to execute save operation");
        }
    }
    @PostMapping("/purchase")
    public ResponseEntity<Double> purchase(@RequestBody PurchaseDTO purchaseDTO) {
        try {
            return new ResponseEntity<>(productService.purchaseAllProducts(purchaseDTO), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
