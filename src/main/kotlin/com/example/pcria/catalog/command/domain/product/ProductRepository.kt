package com.example.pcria.catalog.command.domain.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, ProductId> {
}