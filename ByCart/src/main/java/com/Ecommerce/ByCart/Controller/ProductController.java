package com.Ecommerce.ByCart.Controller;


import com.Ecommerce.ByCart.Exceptions.ResourceNotFoundException;
import com.Ecommerce.ByCart.Model.Product;
import com.Ecommerce.ByCart.Request.AddProductRequest;
import com.Ecommerce.ByCart.Request.ProductUpdateRequest;
import com.Ecommerce.ByCart.Response.ApiResponse;
import com.Ecommerce.ByCart.Service.Product.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final IProductService productService;


    // get all products
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Success!",products));
    }


    @GetMapping("/product/{productId}/product")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long productId){
        try{
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Success!",product));
        }
        catch(ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }



    // add new product
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest addProductRequest){
        try{
            Product product = productService.addProduct(addProductRequest);
            return ResponseEntity.ok(new ApiResponse("Add Product Success!",product));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }

    }

    @PutMapping("/product/{productId}/update")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest, @PathVariable Long productId){
        try{
            Product product = productService.updateProduct(productUpdateRequest,productId);
            return ResponseEntity.ok(new ApiResponse("Update Success!",product));

        }catch(ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @DeleteMapping("/product/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable Long productId){
        try{
            productService.deleteProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Update Success!",null));

        }catch(ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }


    @GetMapping("/products/by/brand-and-name")
    public ResponseEntity<ApiResponse> getProductByBrandAndName(@RequestParam String brand,@RequestParam String name){
        try{
            List<Product> products = productService.getProductByBrandAndName(brand,name);
            if(products.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("No Products Found",null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!",products));

        }catch(ResourceNotFoundException e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/products/by/category-and-brand")
    public ResponseEntity<ApiResponse> getProductByCategoryAndBrand(@RequestParam String category,@RequestParam String brand){
        try{
            List<Product> products = productService.getProductByCategoryAndBrand(category,brand);
            if(products.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("No Products Found",null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!",products));

        }catch(ResourceNotFoundException e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }


    @GetMapping("/product/{name}/product")
    public ResponseEntity<ApiResponse> getProductByName(@PathVariable String name){
        try{
            List<Product> product = productService.getProductByName(name);
            if(product.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Products Found",null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!",product));
        }
        catch(Exception e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Error",null));
        }
    }


    // get products by name
    @GetMapping("/product/by-brand")
    public ResponseEntity<ApiResponse> getProductByBrand(@RequestParam String brand){
        try{
            List<Product> product = productService.getProductByBrand(brand);
            if(product.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Products Found",null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!",product));
        }
        catch(Exception e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/product/{category}/all/products")
    public ResponseEntity<ApiResponse> getProductsByCategory(@PathVariable String category){
        try{
            List<Product> product = productService.getProductsByCategory(category);
            if(product.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Products Found",null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!",product));
        }
        catch(Exception e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }



    public ResponseEntity<ApiResponse> countProductsByBrandAndName(@RequestParam String brand,@RequestParam String name){
        try{
            Long product = productService.countProductsByBrandAndName(brand,name);
            return ResponseEntity.ok(new ApiResponse("Product Count",product));
        }catch (Exception e){
            return ResponseEntity.ok(new ApiResponse(e.getMessage(),null));
        }
    }



}
