package com.store.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Product product;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
