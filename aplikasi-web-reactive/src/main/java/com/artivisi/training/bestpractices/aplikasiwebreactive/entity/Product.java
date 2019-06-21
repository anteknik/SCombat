package com.artivisi.training.bestpractices.aplikasiwebreactive.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document @Data
public class Product {
    @Id
    private String id;
    private String code;
    private String name;
    private BigDecimal price;
}
