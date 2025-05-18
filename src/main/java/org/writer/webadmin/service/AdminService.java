package org.writer.webadmin.service;

import org.writer.webadmin.dto.CreateBrandDto;
import org.writer.webadmin.dto.CreateCategoryDto;
import org.writer.webadmin.dto.CreateProductDto;
import org.writer.webadmin.model.OrderEntity;
import org.writer.webadmin.model.Status;

public interface AdminService {
    void createProduct(CreateProductDto dto);
    void deleteProduct(Long id);
    void updateProduct(CreateProductDto dto);
    void updateStatusOrder(Status status, Long id);
    void createBrand(CreateBrandDto dto);
    void deleteBrand(Integer id);
    void createCategory(CreateCategoryDto dto);
    void deleteCategory(Integer id);

}
