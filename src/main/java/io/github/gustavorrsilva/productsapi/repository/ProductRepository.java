package io.github.gustavorrsilva.productsapi.repository;

import io.github.gustavorrsilva.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
