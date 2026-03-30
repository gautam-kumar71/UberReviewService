package org.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends BaseModel{

    private String driverName;

    @Column(nullable=false,unique = true)
    private String licenseNumber;

    @OneToMany
    /**
     * Persist will create the dependent object's table first in the db and
     * remove will delete both the table if the table holding the primary key is deleted first (in one to many relationship)
     */
    private List<Booking> bookings;

}
