package com.Ecommerce.ByCart.DTO;

import com.Ecommerce.ByCart.Model.Category;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class productDTO {
    private long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
    private List<ImageDTO> images ;
}
