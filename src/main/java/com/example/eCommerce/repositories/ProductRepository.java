package com.example.eCommerce.repositories;

import com.example.eCommerce.forms.ProductForm;
import com.example.eCommerce.models.Product;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getListProduct(){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT products.id,products.name,description,quantity,price,image,categories.name AS category_name FROM products,categories WHERE products.category_id=categories.id ORDER BY id");
        ArrayList<Product> products = new ArrayList<>();
        while (sqlRowSet.next()){
            products.add(new Product(sqlRowSet.getLong("id"),sqlRowSet.getString("name"),
                    sqlRowSet.getString("category_name"),sqlRowSet.getString("description")
                    ,sqlRowSet.getInt("quantity"),sqlRowSet.getFloat("price"),sqlRowSet.getString("image")));
        }
        return products;
    }

    public void addProduct(final String name,final Long categoryId,final String description,final Integer quantity,final Float price,final String image){
        jdbcTemplate.update("INSERT INTO products(name,category_id,description,quantity,price,image) VALUES (?,?,?,?,?,?)",name,categoryId,description,quantity,price,image);
    }

    public void deleteProduct(final Long id){
        jdbcTemplate.update("DELETE FROM products WHERE id=?",id);
    }

    public void editProduct(final String name,final Long categoryId,final String description,final Integer quantity,final Float price,final String image,final Long id){
        if(image==null){
            jdbcTemplate.update("UPDATE products SET name=?,category_id=?,description=?,quantity=?,price=? WHERE id=?", name, categoryId, description, quantity, price, id);
        } else {
            jdbcTemplate.update("UPDATE products SET name=?,category_id=?,description=?,quantity=?,price=?,image=? WHERE id=?", name, categoryId, description, quantity, price, image, id);
        }
    }

    public ProductForm getProductFormById(final Long id){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM products WHERE id=?",id);
        if(sqlRowSet.next()){
            return new ProductForm(id,sqlRowSet.getString("name"),sqlRowSet.getString("description"),sqlRowSet.getInt("quantity"),sqlRowSet.getFloat("price"),sqlRowSet.getLong("category_id"));
        }
        return null;
    }


    public String getProductImageById(final Long id){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT image FROM products WHERE id=?",id);
        if(sqlRowSet.next()){
            return sqlRowSet.getString("image");
        }
        return null;
    }

    public Product getProductById(final Long id){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT categories.id AS categoryId,products.id AS productId,categories.name AS categoryName,products.name AS productName,description,quantity,price,image FROM products,categories WHERE products.id=? AND products.category_id=categories.id",id);
        if(sqlRowSet.next()){
            return new Product(id,sqlRowSet.getString("productName"),sqlRowSet.getString("categoryName"),sqlRowSet.getString("description"),sqlRowSet.getInt("quantity"),sqlRowSet.getFloat("price"),sqlRowSet.getString("image"));
        }
        return null;
    }

    public List<Product> getListProductByCategorySlug(String categorySlug,int page,int pageSize){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT products.id,products.name,description,quantity,price,image,categories.name AS category_name FROM products,categories WHERE products.category_id=categories.id AND categories.slug=? ORDER BY id LIMIT ?,?",categorySlug,(page-1)*pageSize,pageSize);
        ArrayList<Product> products = new ArrayList<>();
        while (sqlRowSet.next()){
            products.add(new Product(sqlRowSet.getLong("id"),sqlRowSet.getString("name"),
                    sqlRowSet.getString("category_name"),sqlRowSet.getString("description")
                    ,sqlRowSet.getInt("quantity"),sqlRowSet.getFloat("price"),sqlRowSet.getString("image")));
        }
        return products;
    }
    public int getTotalProductByCategorySlug(String categorySlug){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT count(*) as total FROM products,categories WHERE products.category_id=categories.id AND categories.slug = ?",categorySlug);
        if(sqlRowSet.next()){
            return sqlRowSet.getInt("total");
        }
        return 0;
    }

}
