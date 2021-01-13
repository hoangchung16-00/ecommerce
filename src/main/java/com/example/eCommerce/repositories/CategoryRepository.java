package com.example.eCommerce.repositories;

import com.example.eCommerce.forms.AddCategoryForm;
import com.example.eCommerce.forms.EditCategoryForm;
import com.example.eCommerce.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCategory(final String name,final Integer sorting,final String slug){
        jdbcTemplate.update("INSERT INTO categories(name,sorting,slug) VALUES(?,?,?)",name,sorting,slug);
    }

    public List<Category> getListCategory(){
        ArrayList<Category> categories = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM categories");
        while (sqlRowSet.next()){
            categories.add(new Category(sqlRowSet.getLong("id"),sqlRowSet.getString("name"),sqlRowSet.getString("slug"),sqlRowSet.getInt("sorting")));
        }
        return categories;
    }

    public void deleteCategory(final Long id){
        jdbcTemplate.update("DELETE FROM categories WHERE id= ?",id);
    }

    public EditCategoryForm getEditCategoryFormById(final Long id){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM categories WHERE id=?",id);
        if(sqlRowSet.next()){
            return new EditCategoryForm(sqlRowSet.getLong("id"),sqlRowSet.getString("name"),sqlRowSet.getInt("sorting"));
        }
        return null;
    }

    public void editCategory(final String name,final Integer sorting,final Long id){
        jdbcTemplate.update("UPDATE categories SET name=?,sorting=? WHERE id= ?",name,sorting,id);
    }

    public Boolean checkCategorySlug(String categorySlug){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM categories WHERE slug=?",categorySlug);
        if(sqlRowSet.next()){
            return true;
        }
        return false;
    }

}
