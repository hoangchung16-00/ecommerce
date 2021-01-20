package com.example.eCommerce.DAOs;

import com.example.eCommerce.entitys.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Categories,Long> {
}
