package org.writer.webadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.writer.webadmin.model.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
}
