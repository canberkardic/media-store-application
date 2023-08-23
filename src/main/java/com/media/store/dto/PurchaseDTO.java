package com.media.store.dto;

import com.media.store.entity.BaseProduct;
import lombok.Data;

import java.util.List;



@Data
public class PurchaseDTO {
    private List<PurchaseItem> items;
}
