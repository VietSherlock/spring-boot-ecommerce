package com.vietsherlock.ecommerce.repository;

import com.vietsherlock.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {

    ProductCategory findByCategoryName(String categoryName);

}
