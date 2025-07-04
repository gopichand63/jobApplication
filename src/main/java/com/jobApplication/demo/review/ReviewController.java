package com.jobApplication.demo.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getallReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllreviews(companyId), HttpStatus.OK);
    }

    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){

    }
}
