package com.artivisi.training.bestpractices.aplikasiwebreactive.service;

import com.artivisi.training.bestpractices.aplikasiwebreactive.entity.Product;
import com.artivisi.training.bestpractices.aplikasiwebreactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

@Service
public class AplikasiService {
    @Autowired private ProductRepository productRepository;

    public Flux<Product> dataProduk() {
        return productRepository.findAll()
                .delayElements(Duration.ofSeconds(1))
                .map(p -> {
                    /*
                    if(new Random().nextInt() % 8 == 0) {
                        throw new IllegalStateException("Simulasi error");
                    }
                    */
                    return p;
                });
    }

    public Mono<Product> saveProduct(Product product) {
        return productRepository.save(product);
    }
}
