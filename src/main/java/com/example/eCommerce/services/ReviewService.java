package com.example.eCommerce.services;

import com.example.eCommerce.models.Review;
import com.example.eCommerce.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public List<Review> getReviewsByProductId(final Long productId) {
        return reviewRepository.getReviewsByProductId(productId);
    }
}