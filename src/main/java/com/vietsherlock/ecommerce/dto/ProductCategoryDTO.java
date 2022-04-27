package com.vietsherlock.ecommerce.dto;

import javax.validation.constraints.NotNull;

public class ProductCategoryDTO {

    private Long id;

    @NotNull(message = "category name can't be null!")
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
