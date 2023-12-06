package com.petshop.ambrozziospetshop.services;

import com.petshop.ambrozziospetshop.entities.Product;
import com.petshop.ambrozziospetshop.entities.ShoppingCart;
import com.petshop.ambrozziospetshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ShoppingCartService {

    @Autowired
    private final ProductService productService;

    public ShoppingCartService (ProductService productService) {
        this.productService = productService;
    }

    public void addToCart(ShoppingCart cart, Long productId, int quantity) {
        Product product = productService.findById(productId);
        if (product != null && product.getQuantity() >= quantity) {
            cart.addItem(product, quantity);
            product.setQuantity(product.getQuantity() - quantity);
            productService.addProduct(product);
        }
    }

    public void removeFromCart(ShoppingCart cart, Long productId, int quantity) {
        Product product = productService.findById(productId);
        if (product != null) {
            cart.removeItem(product);
            product.setQuantity(product.getQuantity() + quantity);
            productService.addProduct(product);
        }
    }
}
