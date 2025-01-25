package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long ID) {
        Optional<Product> product = productRepository.findById(ID);

        if (product.isPresent()) {
            Product p = product.get();

            if (p.getInv() > 0) {
                p.setInv(p.getInv() - 1);
                productRepository.save(p);

                return "/buyProductSuccess";
            }

            else {
                return "/buyProductFailed";
            }
        }

        else {
            return "/buyProductFailed";
        }
    }
}