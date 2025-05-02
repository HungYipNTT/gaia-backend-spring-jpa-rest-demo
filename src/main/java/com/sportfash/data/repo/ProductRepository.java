package com.sportfash.data.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sportfash.data.entities.product.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {

    List<Product> findByBrand(String brand);

    List<Product> findByCategory(String category);

    @Query(value = "SELECT * FROM new_sale_platform.product WHERE product_name LIKE %?1%", nativeQuery = true)
    List<Product> searchByProductName(String keyword);

    @Query(value = "SELECT * FROM new_sale_platform.product WHERE short_description LIKE %?1%", nativeQuery = true)
    List<Product> searchByProductDescription(String keyword);
}
