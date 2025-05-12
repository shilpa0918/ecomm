package com.store.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String attrName;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Product product;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attribute")
    private List<AttributeValue> attributeValues;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}

