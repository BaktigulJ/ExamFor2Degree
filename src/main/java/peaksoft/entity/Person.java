package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity

public class Person {
    @Id
    private Long Id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;

    private Integer age;

    private String email;

    private String gender;

    public Person(String name, Integer age, String email, String gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }
}
