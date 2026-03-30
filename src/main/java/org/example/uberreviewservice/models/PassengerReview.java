package org.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * There are two classes Review & PassengerReview, Review is the parent and PassengerReview is the child
 * now there are two methods builder() in both the parent and child, since the Builder is the static class
 * builder method of child will hide the builder method of the parent, method hiding basically.
 * So, now that becomes a problem like it will give error, how come the builder of the parent
 * will be used right?
 * So, we use SuperBuilder if we want both the child and parent should have build methods.
 *
 *
 * NOTE: VVI, SuperBuilder must be used in the entire hierarchy chain,else it will throw error
 */

@SuperBuilder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerReview extends Review{
 @Column(nullable=false)
  private String passengerReview;
  private Double passengerRating;
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


/**
 * Good 👍
 * Let’s understand TABLE_PER_CLASS problem with NOT NULL using a very simple diagram + example
 *
 * --------------------------------------------------
 * 🎯 Example — Vehicle Inheritance
 *
 * 👨‍👩‍👧‍👦 Parent Class
 *
 * Vehicle
 * - id
 * - brand
 *
 * 🚗 Child Class 1
 *
 * Car
 * - numberOfDoors
 *
 * 🏍️ Child Class 2
 *
 * Bike
 * - hasCarrier
 *
 * --------------------------------------------------
 * 🗄️ Database Tables (TABLE_PER_CLASS)
 *
 * 🚗 CAR table
 *
 * id | brand | number_of_doors
 * 1  | BMW   | 4
 * 2  | Audi  | 2
 *
 * 🏍️ BIKE table
 *
 * id | brand | has_carrier
 * 3  | Hero  | true
 * 4  | Honda | false
 *
 * --------------------------------------------------
 * ⚙️ What Hibernate Does Internally
 *
 * When you run:
 *
 * select v from Vehicle v
 *
 * Hibernate runs UNION query like this
 *
 * SELECT id, brand, number_of_doors, NULL as has_carrier
 * FROM car
 *
 * UNION
 *
 * SELECT id, brand, NULL as number_of_doors, has_carrier
 * FROM bike
 *
 * 👉 Because UNION needs same number of columns
 *
 * So Hibernate adds NULL for missing columns.
 *
 * --------------------------------------------------
 * ❗ Where NOT NULL Problem Happens
 *
 * Suppose you put:
 *
 * number_of_doors → NOT NULL
 *
 * Now in BIKE part of UNION:
 *
 * NULL as number_of_doors
 *
 * 💥 Database error occurs because:
 *
 * - Column is NOT NULL
 * - But UNION is trying to insert NULL temporarily
 *
 * Hence:
 *
 * ✅ TABLE_PER_CLASS + NOT NULL on child fields
 * 👉 Can cause runtime error
 *
 * --------------------------------------------------
 */