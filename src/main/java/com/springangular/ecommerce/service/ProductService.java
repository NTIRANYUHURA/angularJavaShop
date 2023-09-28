package com.springangular.ecommerce.service;

import com.springangular.ecommerce.model.Product;
import com.springangular.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addNewProduct(Product product) {
        return productRepository.save(product);}

    public List<Product> getAllProducts(int pageNumber){

        Pageable pageable = PageRequest.of(pageNumber,30);

       return (List<Product>) productRepository.findAll(pageable);

    }

    public Product getProductDetailsById(Integer productId){
         return productRepository.findById(productId).get();
    }

   public void deleteProductDetails(Integer productId){
        productRepository.deleteById(productId);
   }

   public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId ) {
       if (isSingleProductCheckout) {

           // we are going to buy a single product

           List<Product> list = new ArrayList<>();
           Product product = productRepository.findById(productId).get();
           list.add(product);
           return list;
       } else {

       }

       return new ArrayList<>();

   }

}
