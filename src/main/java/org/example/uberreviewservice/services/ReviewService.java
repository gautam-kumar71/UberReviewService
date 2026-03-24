package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository)
    {
        this.reviewRepository=reviewRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************************");
        Review r= Review.builder()
                .content("hihi")
                .rating(4.0)
//                .createdAt(LocalDateTime.now())  instead of manually passing it enable jpa-auditing and spring-jpa will handle these
//                .updatedAt(LocalDateTime.now())
                .build();

        reviewRepository.save(r);

        List<Review> reviews=reviewRepository.findAll();//findAll getting from spring data jpa
        reviews.stream()
                .forEach((reviewObj)->{System.out.println(reviewObj.getContent());});//getContent is coming from lombok, it is basically the getter from the Review class

        reviewRepository.deleteById(10L);

    }
}
