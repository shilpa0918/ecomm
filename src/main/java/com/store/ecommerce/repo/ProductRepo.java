package com.store.ecommerce.repo;

import com.store.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);

    List<Product> findByCategoryCategoryName(String categoryName);
    @Query(value = "SELECT p.* FROM Product p INNER JOIN attribute a ON p.id = a.product_id INNER JOIN attribute_value av ON a.id = av.attribute_id\n" +
            "            WHERE a.attr_name = :attributeName AND av.attr_value = :attributeValue",
            nativeQuery = true)
    List<Product> findProductByAttrNameAndAttrValue(@Param("attributeName") String attributeName,
                                                       @Param("attributeValue") String attributeValue);
}
