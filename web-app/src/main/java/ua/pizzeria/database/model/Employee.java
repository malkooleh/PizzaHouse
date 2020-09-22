package ua.pizzeria.database.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;

    String description;
}
