package org.bymarium.apirest.javacourse.Repositories;

import org.bymarium.apirest.javacourse.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
