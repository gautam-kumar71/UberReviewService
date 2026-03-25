package org.example.uberreviewservice.models;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@MappedSuperclass

/**
 * @MappedSuperclass
 *handling annotation in spring data jpa--
 * no table for the parent class ;
 * one table for each child clas having its own attribute or parent class attribute
 *code segregated--reused code will be used again and again
 */
public  abstract class BaseModel {
    @Id//used to make the column as primary key column
    @GeneratedValue(strategy = GenerationType.TABLE)//auto increment
    protected Long id;

    @Column(nullable=false)
//    @Temporal(TemporalType.TIMESTAMP)  //deprecated now
    @CreatedDate
    protected LocalDateTime createdAt;//hibernate automatically maps it to timestamp

    @Column(nullable=false)
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected LocalDateTime updatedAt;
}
