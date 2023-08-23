package com.media.store.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Film extends BaseProduct {

    private String directorName;
    private Long rate;

    @Override
    public void setType(String type) {
        super.setType("film");
    }
}
