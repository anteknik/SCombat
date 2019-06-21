package com.artivisi.training.bestpractices.aplikasiwebreactive;

import com.artivisi.training.bestpractices.aplikasiwebreactive.entity.Product;
import com.artivisi.training.bestpractices.aplikasiwebreactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@SpringBootApplication
public class AplikasiWebReactiveApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AplikasiWebReactiveApplication.class, args);
	}

	@Autowired private ProductRepository productRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		productRepository.deleteAll()
				.thenMany(
					Flux.range(1,9)
					.log()
					.map(i -> {
						Product p = new Product();
						p.setId(i.toString());
						p.setCode("P-00"+i);
						p.setName("Product 00"+i);
						p.setPrice(new BigDecimal("10000"+i));
						return p;
					})
					.flatMap(productRepository::save)
				)
				.thenMany(productRepository.findAll())
				.subscribe(System.out::println);
	}
}
