package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Booking extends BaseModel {

    //one driver has many bookings
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})

    /**
     * In Hibernate / JPA, cascade means:
     *
     * “If I perform an operation on a parent entity,
     * automatically apply the same operation to its related (child) entities.”
     */

    private Review review;//we have defined a one to one relationship between Booking and review

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;


    @CreationTimestamp
    private LocalDateTime startDate;
    @UpdateTimestamp
    private LocalDateTime endDate;

    private Long totaldistance;


    @ManyToOne
    private Driver driver;
}
