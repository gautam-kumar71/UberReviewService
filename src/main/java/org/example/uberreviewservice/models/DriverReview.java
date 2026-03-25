package org.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name="driver_review_id")
public class DriverReview extends Review {
  private String driverReview;
}
/**
 *✅       **JOINED Strategy — Primary Key concept (short & simple)**
 *
 *         * Parent table primary key is reused in child table.
 *         * In child table → that column is both Primary Key and Foreign Key.
 *         * Parent table does NOT have any foreign key of child.(Because child is dependent on parent not vice-versa)
 *         * `@PrimaryKeyJoinColumn` is optional.
 *         * It is mainly used to change the column name or make mapping clear.
 *
 *         ⭐ One-line rule:
 *         👉 Child PK = Parent PK (and also FK in child).
 */
