package com.media.store.repository;

import com.media.store.entity.Book;
import com.media.store.entity.MusicAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicAlbumRepository extends JpaRepository<MusicAlbum, Long> {


}

