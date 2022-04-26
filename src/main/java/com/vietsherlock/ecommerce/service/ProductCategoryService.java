package com.vietsherlock.ecommerce.service;

import com.vietsherlock.ecommerce.dto.ProductCategoryDTO;
import com.vietsherlock.ecommerce.entity.ProductCategory;
import com.vietsherlock.ecommerce.mapper.ProductCategoryMapper;
import com.vietsherlock.ecommerce.repository.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepo productCategoryRepo;

    @Autowired
    public ProductCategoryService(ProductCategoryRepo productCategoryRepo){
        this.productCategoryRepo = productCategoryRepo;
    }

    public List<ProductCategoryDTO> readCategories(){
        List<ProductCategory> categories = productCategoryRepo.findAll();
        List<ProductCategoryDTO> categoryDTOS = new ArrayList<>();

        for (ProductCategory category : categories){
            categoryDTOS.add(ProductCategoryMapper.toProductCategoryDTO(category));
        }

        return categoryDTOS;
    }

    public ProductCategoryDTO readCategory(Long categoryId){
        Optional<ProductCategory> optionalProductCategory = productCategoryRepo.findById(categoryId);
        return optionalProductCategory.isPresent() ? ProductCategoryMapper.toProductCategoryDTO(optionalProductCategory.get()) : null;
    }

    public ProductCategoryDTO readCategory(String categoryName){
        return ProductCategoryMapper.toProductCategoryDTO(productCategoryRepo.findByCategoryName(categoryName));
    }

    public void createCategory(ProductCategoryDTO categoryDTO){
        productCategoryRepo.save(ProductCategoryMapper.toProductCategory(categoryDTO));
    }

    public void updateCategory(Long categoryId, ProductCategoryDTO categoryDTO){

        ProductCategory category = productCategoryRepo.getById(categoryId);
        category.setCategoryName(categoryDTO.getCategoryName());

        productCategoryRepo.save(category);
    }

    public void deleteCategory(Long categoryId){
        productCategoryRepo.deleteById(categoryId);
    }


}
