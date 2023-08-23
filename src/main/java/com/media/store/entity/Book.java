package com.media.store.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Book extends BaseProduct {

    @JsonProperty("ISBN")
    private String ISBN;
    private String writerName;


    @Override
    public void setType(String type) {
        super.setType("book");
    }
}
