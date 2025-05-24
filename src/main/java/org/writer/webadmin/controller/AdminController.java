package org.writer.webadmin.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.writer.webadmin.dto.CreateBrandDto;
import org.writer.webadmin.dto.CreateCategoryDto;
import org.writer.webadmin.dto.CreateProductDto;
import org.writer.webadmin.model.Status;
import org.writer.webadmin.service.AdminService;
import org.writer.webadmin.service.impl.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody CreateProductDto dto) {
        adminService.createProduct(dto);
        return "Product created";
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@PathVariable Long id) {
        adminService.deleteProduct(id);
        return "Product deleted";
    }

    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateStatusOrder(@PathVariable Long id, @RequestParam Status status) {
        adminService.updateStatusOrder(status, id);
        return "Status changed";
    }
    
    @PatchMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public String updateProduct(@RequestBody CreateProductDto dto) {
        adminService.updateProduct(dto);
        return "Product updated";
    }

    @PostMapping("/brand")
    @ResponseStatus(HttpStatus.CREATED)
    public String createBrand(@RequestBody CreateBrandDto brand) {
        adminService.createBrand(brand);
        return "Brand created";
    }

    @DeleteMapping("/brand/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBrand(@Valid @PathVariable Integer id) {
        adminService.deleteBrand(id);
        return "Brand removed";
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCategory(@RequestBody CreateCategoryDto categoryDto) {
        adminService.createCategory(categoryDto);
        return "Category created";
    }

    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCategory(@Valid @PathVariable Integer id) {
        adminService.deleteCategory(id);
        return "Category removed";
    }
}
