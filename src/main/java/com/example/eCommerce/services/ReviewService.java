package com.example.eCommerce.services;

import com.example.eCommerce.models.Review;
import com.example.eCommerce.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public List<Review> getReviewsByProductId(final Long productId) {
        return reviewRepository.getReviewsByProductId(productId);
    }

    @Transactional
    public Integer getTotalreviewsByProductId(final Long productId) {
        return reviewRepository.getTotalreviewsByProductId(productId);
    }

    @Transactional
    public int getRatingStarsByProductId(final Long productId){
        List<Review> reviews = reviewRepository.getReviewsByProductId(productId);
        if(reviews.size()==0){
            return 5;
        }
        int totalRating=0;
        for(int i=0;i<reviews.size();i++){
            totalRating=totalRating+reviews.get(i).getRating();
        }
        return totalRating/reviews.size();
    }
}