package io.github.gustavorrsilva.productsapi.controller;

import io.github.gustavorrsilva.productsapi.model.Product;
import io.github.gustavorrsilva.productsapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }



    @PostMapping
    public Product save(@RequestBody() Product product){
           var id = UUID.randomUUID().toString();
           product.setId(id);
           productRepository.save(product);
           return product;

    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);//optional because we don't know if there is a product with this id
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
