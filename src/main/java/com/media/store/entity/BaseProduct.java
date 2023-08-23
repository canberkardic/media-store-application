package com.media.store.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;
    private String name;
    private String genre;
    private String releaseDate;
    private Double basePrice;
    private String type;
}
