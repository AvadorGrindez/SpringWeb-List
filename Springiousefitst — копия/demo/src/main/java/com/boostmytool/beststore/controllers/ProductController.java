package com.boostmytool.beststore.controllers;

import com.boostmytool.beststore.models.Product;
import com.boostmytool.beststore.services.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping({"", "/"}) // Add this annotation to map the method to the HTTP GET request for "/products/list"
    public String showProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products); // Use the correct Model type
        return "products/index"; // This should correspond to your Thymeleaf template
    }
}
