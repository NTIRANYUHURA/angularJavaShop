package com.springangular.ecommerce.repository;

import com.springangular.ecommerce.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> findAll(Pageable pageable);

    public List<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase
            (String key1, String key2, Pageable pageable);

    //Set<Product> findByCategory(Category category);


}
