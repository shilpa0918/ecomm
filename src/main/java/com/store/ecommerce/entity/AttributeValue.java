package com.store.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String attrValue;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Attribute attribute;
}
