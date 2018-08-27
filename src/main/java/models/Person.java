package models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {


    private LocalDate dob;
    private int id;
    private String name;

    public Person(LocalDate dob, String name) {
        this.dob = dob;
        this.name = name;
    }

    public Person() {
    }


    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
