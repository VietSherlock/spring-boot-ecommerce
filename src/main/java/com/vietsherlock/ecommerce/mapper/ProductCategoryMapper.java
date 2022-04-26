package com.vietsherlock.ecommerce.mapper;

import com.vietsherlock.ecommerce.dto.ProductCategoryDTO;
import com.vietsherlock.ecommerce.entity.ProductCategory;

public class ProductCategoryMapper {

    private ProductCategoryMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static ProductCategoryDTO toProductCategoryDTO(ProductCategory category){
        if(category == null)
            return null;
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setId(category.getId());
        productCategoryDTO.setCategoryName(category.getCategoryName());

        return productCategoryDTO;
    }

    public static ProductCategory toProductCategory(ProductCategoryDTO categoryDTO){
        if(categoryDTO == null)
            return null;

        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(categoryDTO.getId());
        productCategory.setCategoryName(categoryDTO.getCategoryName());

        return productCategory;
    }

}
