package com.jobApplication.demo.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllreviews(Long companyId);
    void addReview(Long companyId,Review review);
}
