package com.Ecommerce.ByCart.Service.Product;

import com.Ecommerce.ByCart.Model.Product;
import com.Ecommerce.ByCart.Request.AddProductRequest;
import com.Ecommerce.ByCart.Request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductByBrandAndName(String brand,String name);
    List<Product> getProductByCategoryAndBrand(String brand,String category);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByName(String name);
    Long countProductsByBrandAndName(String brand,String name);
}
