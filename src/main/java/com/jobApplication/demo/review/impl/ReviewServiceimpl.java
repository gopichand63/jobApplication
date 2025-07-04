package com.jobApplication.demo.review.impl;

import com.jobApplication.demo.review.Review;
import com.jobApplication.demo.review.ReviewRepository;
import com.jobApplication.demo.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceimpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceimpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllreviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;

    }

    @Override
    public void addReview(Long companyId, Review review) {

    }
}
