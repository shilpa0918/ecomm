package com.store.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String attrName;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Product product;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "attribute")
    private List<AttributeValue> attributeValues;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
