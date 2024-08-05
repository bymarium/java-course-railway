package org.bymarium.apirest.javacourse.Controllers;

import org.bymarium.apirest.javacourse.Entities.Product;
import org.bymarium.apirest.javacourse.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found" + id));
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product product1 = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found" + id));

        product1.setName(product.getName());
        product1.setPrice(product.getPrice());

        return productRepository.save(product1);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found" + id));

        productRepository.delete(product);

        return "Product deleted with id: " + id;
    }
}
