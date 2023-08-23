package com.media.store.service.impl;

import com.media.store.dto.PurchaseDTO;
import com.media.store.dto.PurchaseItem;
import com.media.store.entity.BaseProduct;
import com.media.store.repository.BookRepository;
import com.media.store.repository.FilmRepository;
import com.media.store.repository.MusicAlbumRepository;
import com.media.store.service.CampaignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private MusicAlbumRepository musicAlbumRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Double calculateCampaigns(PurchaseDTO purchaseDTO) {
        try {
            List<PurchaseItem> items = purchaseDTO.getItems();
            List<BaseProduct> products = new ArrayList<>();

            for(PurchaseItem i : items){
                String productId = i.getProductId();

                var bookResult = bookRepository.findById(Long.valueOf(productId));
                var filmResult = filmRepository.findById(Long.valueOf(productId));
                var musicAlbumResult = musicAlbumRepository.findById(Long.valueOf(productId));

                if(bookResult.isPresent()){
                    products.add(bookResult.get());
                } else if (filmResult.isPresent()) {
                    products.add(filmResult.get());
                } else if (musicAlbumResult.isPresent()) {
                    products.add(musicAlbumResult.get());
                }
            }

            return 10.0;
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public Double calculateFirstCampaing(List<BaseProduct> products) {

        return 10.0;
    }

    @Override
    public Double calculateSecondCampaing(List<BaseProduct> products) {
        return null;
    }
}
