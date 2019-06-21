package com.artivisi.training.bestpractices.aplikasiwebreactive.repository;

import com.artivisi.training.bestpractices.aplikasiwebreactive.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {

}
