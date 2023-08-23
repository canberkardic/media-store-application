package com.media.store.service.impl;


import com.media.store.dto.ProductSaveRequestDTO;
import com.media.store.dto.PurchaseDTO;
import com.media.store.entity.BaseProduct;
import com.media.store.entity.Book;
import com.media.store.entity.Film;
import com.media.store.entity.MusicAlbum;
import com.media.store.repository.BookRepository;
import com.media.store.repository.FilmRepository;
import com.media.store.repository.MusicAlbumRepository;
import com.media.store.service.CampaignService;
import com.media.store.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private MusicAlbumRepository musicAlbumRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CampaignService campaignService;

    @Override
    public List<BaseProduct> getAllProducts() {
        List<Book> books = bookRepository.findAll();
        List<Film> films = filmRepository.findAll();
        List<MusicAlbum> musicAlbums = musicAlbumRepository.findAll();

        List<BaseProduct> products = new ArrayList<>();
        products.addAll(books);
        products.addAll(films);
        products.addAll(musicAlbums);

        return products;
    }
    @Override
    public Double purchaseAllProducts(PurchaseDTO purchaseDTO) {
        Double result = campaignService.calculateCampaigns(purchaseDTO);
        return result;
    }

    @Override
    public String saveProduct(ProductSaveRequestDTO request) {
        String type = request.getProductType();
        var product = request.getProduct();

        String message = "Successfully saved " + type;


        switch (type){
            case "book" :
                Book book = new Book();

                book = modelMapper.map(product, Book.class);
                bookRepository.save(book);
                message += String.format(" %s",book.getName());
                break;
            case "film" :
                Film film = modelMapper.map(product, Film.class);
                filmRepository.save(film);
                message += String.format(" %s",film.getName());
                break;
            case "musicAlbum" :
                MusicAlbum musicAlbum = modelMapper.map(product, MusicAlbum.class);
                musicAlbumRepository.save(musicAlbum);
                message += String.format(" %s",musicAlbum.getName());
                break;
            default:
                throw new RuntimeException();
        }
        return message;
    }



}
