package org.writer.webadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.writer.webadmin.model.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
