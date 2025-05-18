package org.writer.webadmin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.writer.webadmin.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
