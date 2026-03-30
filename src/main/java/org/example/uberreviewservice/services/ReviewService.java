package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.BookingStatus;
import org.example.uberreviewservice.models.PassengerReview;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReviewService implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {

        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }






    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************************");
        Review r = Review.builder()
                .content("hihi")
                .rating(4.0)

//                .createdAt(LocalDateTime.now())  instead of manually passing it enable jpa-auditing and spring-jpa will handle these
//                .updatedAt(LocalDateTime.now())
                .build();

        PassengerReview r2 = PassengerReview.builder().passengerRating(5.0).passengerReview("passengerReview").build();


        Booking b = Booking
                .builder()
                .review(r)//due to one-one relationship between booking & review, the primary key of the review is stored as the foreign key in the booking table
                .bookingStatus(BookingStatus.COMPLETED)
                .totaldistance(50L)
                .build();  // A BOOKING OBJECT

//        reviewRepository.save(r);//cascade persist will automatically save that review first before booking because booking is dependent on review
        reviewRepository.save(r2);//saving passenger review

        bookingRepository.save(b);
        bookingRepository.deleteById(252L);//here the parent table entry is being deleted, so its corresponding child table entry will also be deleted


//        reviewRepository.save(b);
        List<Review> reviews = reviewRepository.findAll();//findAll getting from spring data jpa
        reviews.stream()
                .forEach((reviewObj) -> {
                    System.out.println(reviewObj.getContent());
                });//getContent is coming from lombok, it is basically the getter from the Review class

        reviewRepository.deleteById(10L);

    }
}
