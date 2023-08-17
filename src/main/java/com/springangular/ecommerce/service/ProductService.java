package com.springangular.ecommerce.service;

import com.springangular.ecommerce.model.Product;
import com.springangular.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addNewProduct(Product product) {
        return productRepository.save(product);}

    public List<Product> getAllProducts(){
           return (List<Product>) productRepository.findAll();
    }

    public Product getProductDetailsById(Integer productId){
         return productRepository.findById(productId).get();
    }

   public void deleteProductDetails(Integer productId){
        productRepository.deleteById(productId);
   }
}
