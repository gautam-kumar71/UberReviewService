package org.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review{
// @Column(nullable=false)
  private String passengerReview;
  private String passengerRating;
}

/**
 * ✅ Advantages of SINGLE_TABLE inheritance
 *
 * Fastest read performance (no joins)
 * Simple schema
 * Efficient polymorphic queries
 *
 * ❌ Disadvantages
 *
 * Many NULL columns
 * Table becomes very wide
 * Hard to apply NOT NULL constraints
 * Poor database normalization
 */
