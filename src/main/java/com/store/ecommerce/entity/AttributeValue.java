package com.store.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String attrValue;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Attribute attribute;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
