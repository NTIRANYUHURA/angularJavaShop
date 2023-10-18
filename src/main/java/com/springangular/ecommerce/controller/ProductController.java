package com.springangular.ecommerce.controller;

import com.springangular.ecommerce.model.ImageModel;

import com.springangular.ecommerce.model.Product;

import com.springangular.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;



    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,

                                 @RequestPart("imageFile") MultipartFile[] file) {


        // return productService.addNewProduct(product);

        try {

            Set<ImageModel> images = uploadImage(file);
            product.setProductImages(images);



            productService.addNewProduct(product);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


        return product;
    }


    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        for (MultipartFile file : multipartFiles) {

            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()

            );
            imageModels.add(imageModel);
        }

        return imageModels;
    }


    @GetMapping({"/getAllProducts"})
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "") String searchKey) {
        List<Product> result = productService.getAllProducts(pageNumber, searchKey);

        System.out.println("Result size is " + result.size());
        return result;

    }


    @GetMapping("/getProductDetailsById/{productId}")
    public Product getProductDetailsById(@PathVariable("productId") Integer productId) {
        return productService.getProductDetailsById(productId);

    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping({"/deleteProductDetails/{productId}"})
    public void deleteProductDetails(@PathVariable("productId") Integer productId) {
        productService.deleteProductDetails(productId);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getProductDetails/{isSingleProductCheckout}/{productId}"})
    public List<Product> getProductDetails(@PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
                                           @PathVariable(name = "productId") Integer productId) {
        return productService.getProductDetails(isSingleProductCheckout, productId);


    }

    //get all products of any catId

    /*@GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getProductOfCategory(@PathVariable(name = "categoryId") Integer categoryId
    ){

      Category category = new Category();
      category.setCategoryId(categoryId);
      Set<Product> productsOfCategory = this.productService.getProductsOfCategory(category);
      return ResponseEntity.ok(productsOfCategory);

    } */

    //@GetMapping("/category/{productId}")
    //public ResponseEntity<?> getProductsOfCategory(@PathVariable("productId") Integer productId ){
       // Category category = new Category();
        //Set<Product> productsOfCategory = this.productService.getProductsOfCategory(category);
        //return ResponseEntity.ok(productsOfCategory);
    //}

    @PostMapping("/product/{categoryId}")
    public ResponseEntity<Product> postProduct(@PathVariable long categoryId, @ModelAttribute Product product ) throws IOException {
        Product prod = productService.postProduct(categoryId, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }


}
