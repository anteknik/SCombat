package com.artivisi.training.bestpractices.aplikasiwebreactive.controller;

import com.artivisi.training.bestpractices.aplikasiwebreactive.entity.Product;
import com.artivisi.training.bestpractices.aplikasiwebreactive.repository.ProductRepository;
import com.artivisi.training.bestpractices.aplikasiwebreactive.service.AplikasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired private AplikasiService aplikasiService;

    @GetMapping
    public Flux<Product> dataProduk() {
        return aplikasiService.dataProduk();
    }

    @PostMapping
    public Mono<Product> simpan(@RequestBody Product product) {
        return aplikasiService.saveProduct(product);
    }
}
