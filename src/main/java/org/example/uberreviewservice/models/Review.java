package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


/**
 * @Builder is used to implement the Builder Design Pattern automatically.
 *
 * It helps you create objects in a readable and flexible way,
 * instead of using long constructors.
 */





@SuperBuilder
@Getter
@Setter
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
@Inheritance(strategy=InheritanceType.JOINED)
/**
 * When an entity is persisted or updated, JPA triggers lifecycle events.
 * The AuditingEntityListener listens to these events and automatically sets
 * timestamp fields before the SQL operation is executed.
 */

public class Review extends BaseModel{

//    @Column(nullable=false)
    private String content;

    private Double rating;

    @ManyToOne
    private Driver driver;


//    public Review(){} //or add the annotation @NoArgsConstructor because hibernate wants a no args constructor
}


/**
 * In TABLE_PER_CLASS inheritance,
 * each concrete entity class has its own table containing both parent and child properties.
 * Polymorphic queries are implemented using UNION.
 */

/**
 *✅ Advantages of TABLE_PER_CLASS
 *
 * ✔ No NULL columns
 * ✔ Proper normalization
 * ✔ Clean table design
 * ✔ Easy DB constraints
 * ✔ Each table stores only relevant fields
 *
 * ❌ Disadvantages
 *
 * ❌ Polymorphic queries are slow
 *         (because UNION)
 *
 * ❌ ID generation tricky
 *         (IDENTITY not recommended)
 *
 * ❌ More tables to manage
 *
 * ❌ Performance issue when hierarchy large
 */


/**
 *IN joined, it will only create the corresponding child properties in the child table and corresponding
 * parent properties, in the parent's child and moreover, the primary key in the parent table will act as
 * a foreign key in the child table
 */