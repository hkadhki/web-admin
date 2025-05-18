package org.writer.webadmin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.writer.webadmin.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
