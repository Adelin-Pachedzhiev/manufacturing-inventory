package com.tusofia.manufacturinginventory.controller;


import com.tusofia.manufacturinginventory.entity.Product;
import com.tusofia.manufacturinginventory.entity.ProductCategory;
import com.tusofia.manufacturinginventory.entity.UnitOfMeasure;
import com.tusofia.manufacturinginventory.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Controller
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/allProducts")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();

        model.addAttribute("products", products);

        return "products/list-products";
    }

    @GetMapping("/createProductForm")
    public String getFormForAddProduct(Model model) {
        List<ProductCategory> productCategories = productService.getAllCategories();
        model.addAttribute("productCategories", productCategories);

        List<UnitOfMeasure> unitsOfMeasure = productService.getUnitsOfMeasure();
        model.addAttribute("unitsOfMeasure", unitsOfMeasure);

        model.addAttribute("product", new Product());

        return "products/add-edit-product";
    }

    @GetMapping("/editProductForm")
    public String getFormForEditProduct(@RequestParam Long productId, Model model) {

        Optional<Product> productOptional = productService.getProductById(productId);

        productOptional.ifPresent(product -> model.addAttribute("product", product));

        List<ProductCategory> productCategories = productService.getAllCategories();
        model.addAttribute("productCategories", productCategories);

        List<UnitOfMeasure> unitsOfMeasure = productService.getUnitsOfMeasure();
        model.addAttribute("unitsOfMeasure", unitsOfMeasure);

        return "products/add-edit-product";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<ProductCategory> productCategories = productService.getAllCategories();
            model.addAttribute("productCategories", productCategories);

            List<UnitOfMeasure> unitsOfMeasure = productService.getUnitsOfMeasure();
            model.addAttribute("unitsOfMeasure", unitsOfMeasure);

            return "products/add-edit-product";
        }

        if (isNull(product.getCreatedAt())) {
            product.setCreatedAt(LocalDateTime.now());
        }

        productService.saveProduct(product);

        return "products/product-saved";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long productId) {
        productService.deleteProduct(productId);

        return "redirect:/products/allProducts";
    }
}

