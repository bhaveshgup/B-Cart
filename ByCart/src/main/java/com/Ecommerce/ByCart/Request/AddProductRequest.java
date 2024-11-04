package com.Ecommerce.ByCart.Request;

import com.Ecommerce.ByCart.Model.Category;
import lombok.Data;
import java.math.BigDecimal;


@Data
public class AddProductRequest {
    private long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
}
