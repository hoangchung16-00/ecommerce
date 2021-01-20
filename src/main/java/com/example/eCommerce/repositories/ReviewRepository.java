package com.example.eCommerce.repositories;

import com.example.eCommerce.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Review> getReviewsByProductId(final Long productId){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM reviews WHERE product_id=?",productId);
        ArrayList<Review> reviews = new ArrayList<>();
        if(sqlRowSet.next()){
            reviews.add(new Review(sqlRowSet.getLong("id"),productId,sqlRowSet.getInt("rating"),sqlRowSet.getString("name"),sqlRowSet.getString("description")));

        }
        return reviews;
    }

    public Integer getTotalreviewsByProductId(final Long productId){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT COUNT(*) AS totalReview FROM reviews WHERE product_id=?",productId);
        if(sqlRowSet.next()){
            return sqlRowSet.getInt("totalReview");
        }
        return null;
    }
}
