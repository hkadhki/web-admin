package org.writer.webadmin.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.writer.webadmin.dto.CreateBrandDto;
import org.writer.webadmin.dto.CreateCategoryDto;
import org.writer.webadmin.dto.CreateProductDto;
import org.writer.webadmin.dto.SpecDto;
import org.writer.webadmin.model.*;
import org.writer.webadmin.repository.*;
import org.writer.webadmin.service.AdminService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final SpecRepository specRepository;
    private final BrandRepository brandRepository;
    private final OrderRepository orderRepository;

    public AdminServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, SpecRepository specRepository, BrandRepository brandRepository, OrderRepository orderRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.specRepository = specRepository;
        this.brandRepository = brandRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public void createProduct(CreateProductDto dto) {
        BrandEntity brandEntity = brandRepository.findById(dto.getBrandId()).orElse(null);
        CategoryEntity categoryEntity = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        Date date = Date.valueOf(LocalDate.now());
        ProductEntity product = new ProductEntity(null, dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getStockQuantity(), date, date,categoryEntity,brandEntity );
        productRepository.save(product);
        for(SpecDto specDto : dto.getSpecs()) {
            specRepository.save(new SpecsEntity(null, specDto.getName(), specDto.getValue(), product));
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateProduct(CreateProductDto dto) {
        BrandEntity brandEntity = brandRepository.findById(dto.getBrandId()).orElse(null);
        CategoryEntity categoryEntity = categoryRepository.findById(dto.getCategoryId()).orElseThrow();
        Date date = Date.valueOf(LocalDate.now());
        ProductEntity productEntity = productRepository.findById(dto.getId()).orElse(null);
        ProductEntity product = new ProductEntity(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getStockQuantity(), productEntity.getCreatedAt() == null ? date : productEntity.getCreatedAt(), date,categoryEntity,brandEntity );
        productRepository.saveAndFlush(product);
        for(SpecDto specDto : dto.getSpecs()) {
            specRepository.saveAndFlush(new SpecsEntity(specDto.getId(), specDto.getName(), specDto.getValue(), product));
        }
    }

    @Transactional
    @Override
    public void updateStatusOrder(Status status, Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow();
        order.setStatus(status.toString());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void createBrand(CreateBrandDto dto) {
        brandRepository.save(new BrandEntity(null, dto.getName(), dto.getCountry()));
    }

    @Override
    public void deleteBrand(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public void createCategory(CreateCategoryDto dto) {
        categoryRepository.save(new CategoryEntity(null, dto.getName(), dto.getDescription()));
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
