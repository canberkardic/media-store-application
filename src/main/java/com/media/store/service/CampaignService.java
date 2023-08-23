package com.media.store.service;

import com.media.store.dto.PurchaseDTO;
import com.media.store.entity.BaseProduct;

import java.util.List;

public interface CampaignService {

    Double calculateCampaigns(PurchaseDTO purchaseDTO);
    Double calculateFirstCampaing(List<BaseProduct> products);
    Double calculateSecondCampaing(List<BaseProduct> products);

}
