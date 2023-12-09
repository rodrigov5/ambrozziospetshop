package com.petshop.ambrozziospetshop.domain.services.implementations;

import com.petshop.ambrozziospetshop.domain.dtos.ProductDTO;
import com.petshop.ambrozziospetshop.domain.entities.ProductEntity;
import com.petshop.ambrozziospetshop.domain.repositories.IProductRepository;
import com.petshop.ambrozziospetshop.domain.services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity create(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(productDTO, productEntity);

        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
