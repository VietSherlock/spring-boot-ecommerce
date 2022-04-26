package com.vietsherlock.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id") // join by "category_id" foreign key
    private ProductCategory category;

    @Column(name = "sku")
    private @NotNull String sku;

    @Column(name = "name")
    private @NotNull String name;

    @Column(name = "description")
    private String descriptionString;

    @Column(name = "unit_price") // should use BigDecimal for money data
    private @NotNull BigDecimal unitPrice;

    @Column(name = "image_url")
    private @NotNull String imageUrl;

    @Column(name = "active")
    private @NotBlank boolean active;

    @Column(name = "units_in_stock")
    private @NotBlank int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp // this annotation will automatically get time value at insert time
    private @NotBlank Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp // this annotation will automatically update time value at insert/update time
    private @NotBlank Date lastUpdated;

}
