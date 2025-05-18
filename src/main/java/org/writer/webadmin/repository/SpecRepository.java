package org.writer.webadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.writer.webadmin.dto.SpecDto;
import org.writer.webadmin.model.SpecsEntity;

import java.util.List;

public interface SpecRepository extends JpaRepository<SpecsEntity, Long> {


    List<SpecsEntity> findByProduct_Id(Long productId);
}
