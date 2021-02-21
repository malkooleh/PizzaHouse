package ua.pizzeria.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "roles")
public class Roles {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
