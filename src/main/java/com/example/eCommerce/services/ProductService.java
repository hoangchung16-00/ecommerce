package com.example.eCommerce.services;

import com.example.eCommerce.forms.ProductForm;
import com.example.eCommerce.models.Product;
import com.example.eCommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getListProduct(){
        return productRepository.getListProduct();
    }

    @Transactional
    public void addProduct(final String name,final Long categoryId,final String description,final Integer quantity,final Float price,final String image){
        productRepository.addProduct(name,categoryId,description,quantity,price,image);
    }

    @Transactional
    public void deleteProduct(final Long id){
        productRepository.deleteProduct(id);
    }

    @Transactional
    public void editProduct(final String name,final Long categoryId,final String description,final Integer quantity,final Float price,final String image,final Long id){
        productRepository.editProduct(name,categoryId,description,quantity,price,image,id);
    }

    @Transactional
    public ProductForm getProductFormById(final Long id){
        return productRepository.getProductFormById(id);
    }

    @Transactional
    public String getProductImageById(final Long id){
        return productRepository.getProductImageById(id);
    }

    @Transactional
    public List<Product> getListProductByCategorySlug(String categorySlug,int page,int pageSize){
        return productRepository.getListProductByCategorySlug(categorySlug,page,pageSize);
    }

    @Transactional
    public int getTotalProductByCategorySlug(String categorySlug){
        return productRepository.getTotalProductByCategorySlug(categorySlug);
    }

    @Transactional
    public Product getProductById(final Long id){
        return productRepository.getProductById(id);
    }
}
