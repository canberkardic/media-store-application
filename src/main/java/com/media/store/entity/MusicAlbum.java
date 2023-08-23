package com.media.store.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class MusicAlbum extends BaseProduct {
    @JsonProperty("singerName")
    private String singerName;
    @JsonProperty("numberOfSongs")
    private Integer numberOfSongs;

    @Override
    public void setType(String type) {
        super.setType("musicAlbum");
    }
}
