package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
/**
 * @Builder is used to implement the Builder Design Pattern automatically.
 *
 * It helps you create objects in a readable and flexible way,
 * instead of using long constructors.
 */
@NoArgsConstructor
@AllArgsConstructor

/**
        | Annotation            | Needed by      | Why                                 |
        | --------------------- | -------------- | ----------------------------------- |
        | `@NoArgsConstructor`  | Hibernate      | to create entity object             |
        | `@AllArgsConstructor` | Lombok Builder | to construct object with all fields |
*/

@Entity(name="bookreview")//logical table name for spring-data-jpa
@Table(name ="bookingreview")//will change the table name to bookingreview in the the database end
@EntityListeners(AuditingEntityListener.class)

/**
 * When an entity is persisted or updated, JPA triggers lifecycle events.
 * The AuditingEntityListener listens to these events and automatically sets
 * timestamp fields before the SQL operation is executed.
 */
public class Review extends BaseModel{

    @Column(nullable=false)
    private String content;

    private Double rating;



//    public Review(){} //or add the annotation @NoArgsConstructor because builder wants a no args constructor
}
