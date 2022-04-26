package com.vietsherlock.ecommerce.controller;

import com.vietsherlock.ecommerce.common.ApiResponse;
import com.vietsherlock.ecommerce.dto.ProductCategoryDTO;
import com.vietsherlock.ecommerce.service.ProductCategoryService;
import com.vietsherlock.ecommerce.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categories")
public class ProductCategoryController {

    private final ProductCategoryService categoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductCategoryDTO>> getCategories() {
        return new ResponseEntity<>(categoryService.readCategories(), HttpStatus.OK);
    }

    @GetMapping("/{categoryID}")
    public ResponseEntity<ProductCategoryDTO> getCategoryById(@PathVariable(name = "categoryID") Long categoryId) {
        return new ResponseEntity<>(categoryService.readCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ProductCategoryDTO> getCategoryByName(@RequestParam(name = "categoryName") String categoryName) {
        return new ResponseEntity<>(categoryService.readCategory(categoryName), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody ProductCategoryDTO categoryDTO) {
        if (Helper.isNotNull(categoryService.readCategory(categoryDTO.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "category already exist!"), HttpStatus.CONFLICT);
        }

        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(new ApiResponse(true, "category is created!"), HttpStatus.CREATED);
    }

    @PutMapping("/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable(name = "categoryID") Long categoryId, @RequestBody ProductCategoryDTO categoryDTO) {
        if (Helper.isNotNull(categoryService.readCategory(categoryId))) {
            categoryService.updateCategory(categoryId, categoryDTO);
            return new ResponseEntity<>(new ApiResponse(true, "category successfully updated!"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ApiResponse(false, "category doesn't exist!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{categoryID}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable(name = "categoryID") Long categoryId) {
        if (Helper.isNotNull(categoryService.readCategory(categoryId))) {
            categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(new ApiResponse(true, "category successfully deleted!"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ApiResponse(false, "category doesn't exist!"), HttpStatus.NOT_FOUND);
    }

}
