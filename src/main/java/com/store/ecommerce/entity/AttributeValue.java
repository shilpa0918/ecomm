package com.store.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String attrValue;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Attribute attribute;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
